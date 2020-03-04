package com.pipe42.data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Data;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;
import com.pipe42.main.Initialize;
import com.pipe42.prefs.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * These are all the methods relating to implementing Json as a database.
 * This class should not be called directly. Instead use the {@com.pipe42.data.DatabaseFactoryProvider} for that.
 * In this case the Main method initiates a "factory" object through which we can call any method independent
 * of the underlying database.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.DatabaseFactoryProvider
 * @see com.pipe42.data.DatabaseIO
 * @see com.pipe42.main.Main
 */
public class DatabaseJson implements DatabaseIO {

    private static final Logger log = LoggerFactory.getLogger(DatabaseJson.class);
    private static Data database;


    /* CONSTRUCTORS */

    /**
     * The default constructor.
     * Sets the database variable for current set of data so that we save ourselves
     * frequent direct reads of the json file.
     */
    public DatabaseJson() {
        database = getJsonData();
        log.trace("DataBaseJson: New instance created.");
    }


    /* IMPLEMENTED METHODS */

    /**
     * Writes a Data object to the Json database.
     * NOTE! This will completely overwrite the json file with the new contents of the Data object.
     * @param data a Data object containing the entire content of the Json database.
     * @return True if {@writeJsonData} returns true, false if not.
     * @see com.pipe42.data.pojos.Data
     */
    @Override
    public Boolean writeAll(Data data) {

        log.debug("writeAll(): Returned a new Data object sent to writeJsonData: " + data);

        return writeJsonData(data);
    }

    /**
     * Returns general information about the database
     * @return tba
     */
    @Override
    public String getDatabaseInfo() {

        // TODO implement this method
        log.debug("getDatabseInfo(): Returned the info from Json static database variable.");

        return "Json";
    }


    // PROJECT METHODS
    //

    /**
     * Takes an unique ID and returns a Project object if it equals the project ID of an existing Project.
     * @param id A project ID
     * @return The Project object, otherwise NULL.
     */
    @Override
    public Project getProjectByID(String id) {

        List<Project> projectList = database.getProject();

        for (Project project: projectList) {
            if (project.getProjectID().equals(id)) {
                log.debug("getProjectByID(): Returned a Project object from Json static database variable.");
                return project;
            }
        }

        log.info("getProjectByID(): Returned NULL - no such Project corresponding to the input ID.");
        return null;
    }

    /**
     * Takes a string and returns a Project object if it equals the name of an existing Project.
     * Note that this is case independent.
     * @param name Name of a project, case independent.
     * @return A Project object or NULL when none.
     */
    @Override
    public Project getProjectByName(String name) {

        List<Project> projectList = database.getProject();

        for (Project project: projectList) {
            if (project.getProjectName().toLowerCase().equals(name.toLowerCase())) {
                log.debug("getProjectByName(): Returned a Project object from Json static database variable.");
                return project;
            }
        }

        log.info("getProjectByName(): Returned NULL - no such Project corresponding to the input name.");
        return null;
    }

    /**
     * Takes the prefix string and returns a Project object.
     * @param prefix a project prefix case independent
     * @return a Project object, otherwise NULL
     */
    @Override
    public Project getProjectByPrefix(String prefix) {

        List<Project> projectList = database.getProject();

        for (Project project: projectList) {
            if (project.getProjectPrefix().toLowerCase().equals(prefix.toLowerCase())) {
                log.debug("getProjectByPrefix(): Returned a Project object from Json static database variable.");
                return project;
            }
        }

        log.info("getProjectByPrefix(): Returned NULL - no such Project corresponding to the input prefix.");
        return null;
    }

    /**
     * Returns a list of all projects.
     * @return a list of Project objects
     */
    @Override
    public List<Project> getAllProjects() {

        log.debug("getAllProjects(): Read all Project objects into a list from the Json static database variable.");

        return database.getProject();
    }

    /**
     * Appends a Project entry into the json database.
     * @param project list of Project objects
     */
    @Override
    public void writeProject(Project project) {

        // and then add it to current list of Application objects.
        List<Project> projectList = database.getProject();
        projectList.add(project);

        Data container = new Data(projectList, database.getApplication(), database.getOwner(), database.getEngine());
        writeJsonData(container);

        log.debug("writeApplication(): A new Data object sent to writeJsonData: " + container);
    }

    /**
     * Deletes a project from the database based on its unique ID.
     * @param id project ID
     */
    @Override
    public void deleteProject(String id) {

        // list all projects, find the right one and delete it
        List<Project> projectList = database.getProject();
        projectList.removeIf(project -> project.getProjectID().equals(id));

        Data container = new Data(projectList, database.getApplication(), database.getOwner(), database.getEngine());
        writeJsonData(container);

        log.debug("deleteProject(): A new Data object sent to writeJsonData (project id "+ id +" deleted):  " + container);
    }


    // OWNER METHODS
    //

    /**
     * List all project owners in the json database.
     * @return list of Owner objects
     */
    @Override
    public List<Owner> getAllOwners() {

        log.debug("getAllOwners(): Read all Owner objects into a list from the Json static database variable.");

        return database.getOwner();
    }

    /**
     * Deletes a project owner based on the ID of the owner.
     * @param id owner ID
     */
    @Override
    public void deleteQwner(String id) {

        // TODO implement this method
        log.debug("deleteOwner(): A new Data object sent to writeJsonData (owner id "+ id +" deleted):  "); // TODO add the container to log
    }

    /**
     * Appends a project owner into the json database.
     * @param owner list of entries of type Owner
     */
    @Override
    public void writeOwner(Owner owner) {

        // and then add it to current list of Application objects
        List<Owner> ownerList = database.getOwner();
        ownerList.add(owner);

        Data container = new Data(database.getProject(), database.getApplication(), ownerList, database.getEngine());
        writeJsonData(container);

        log.debug("writeOwner(): A new Data object sent to writeJsonData: " + container);
    }


    // APPLICATION METHODS
    //

    /**
     * Get all software applications in the json database.
     * @return list of Application objects
     */
    @Override
    public List<Application> getAllApps() {

        log.debug("getAllApps(): Read all Application objects into a list from the Json static database variable.");

        return database.getApplication();
    }

    /**
     * Appends a software application into the json database.
     * @param appData an Application object
     */
    @Override
    public void writeApplication(Application appData) {

        // and then add it to current list of Application objects
        List<Application> appList = database.getApplication();
        appList.add(appData);

        Data container = new Data(database.getProject(), appList, database.getOwner(), database.getEngine());
        writeJsonData(container);

        log.debug("writeApplication(): A new Data object sent to writeJsonData: " + container);
    }

    /**
     * Deletes a software application from the json database.
     * @param id the application ID
     */
    @Override
    public void deleteApplication(String id) {

        // TODO add deleteApplication method
        log.debug("deleteApplication(): A new Data object sent to writeJsonData (application id "+ id +" deleted):  "); // TODO add the container to log
    }


    // RENDERENGINE METHODS
    //

    /**
     * Get all render engines from the json database.
     * @return list of Renderengine objects
     */
    @Override
    public List<Renderengine> getAllEngines() {

        log.debug("getAllEngines(): Read all Renderengine objects into a list from the Json static database variable.");

        return database.getEngine();
    }

    /**
     * Deletes a render engine from the json database.
     * @param id renderengine ID
     */
    @Override
    public void deleteRenderengine(String id) {

        // TODO add deleteRenderengine method
        log.debug("deleteRenderEngine(): A new Data object sent to writeJsonData (engine id "+ id +" deleted):  "); // TODO add the container to log
    }

    /**
     * Appends a render engine to the json database.
     * @param engine Renderengine object
     */
    @Override
    public void writeRenderengine(Renderengine engine) {

        // and then add it to current list of Application objects
        List<Renderengine> engineList = database.getEngine();
        engineList.add(engine);

        Data container = new Data(database.getProject(), database.getApplication(), database.getOwner(), engineList);
        writeJsonData(container);

        log.debug("writeRenderengine(): A new Data object sent to writeJsonData: " + container);
    }


    /* LOCAL METHODS */

    /**
     * Constructs a Json file (overwrites) with data contained in the Data object
     * in the path defined by getFileJson
     * @param data an object of type Data
     */
    private Boolean writeJsonData(Data data) {

        String pathToJson = UserPreferences.userSettings.get("databaseJsonDataPath", "");

        FileWorks fw = new FileWorks();
        File jsonfile = fw.readFile(pathToJson);

        // and write the new Data object to json.data
        try {
            Initialize.mapper.writeValue(jsonfile, data);
            log.info("writeJsonData(): Data object has been written to json file: " + data);
            database = getJsonData(); // and update the database variable
            return true;
        } catch (JsonParseException e) {
            log.error("writeJsonData(): Json parse (Jackson) failed.");
            e.printStackTrace();
        } catch (JsonMappingException e) {
            log.error("writeJsonData(): Json mapper (Jackson) failed.");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("writeJsonData(): Writing to json failed.");
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Reads the json file specified and returns all the contents as a single Data object.
     * @return a Data object. otherwise NULL.
     */
    private Data getJsonData() {

        String pathToJson = UserPreferences.userSettings.get("databaseJsonDataPath", "");

        Data content = null;
        FileWorks fw = new FileWorks();

        File jsonfile = fw.readFile(pathToJson);

        try {
            content = Initialize.mapper.readValue(jsonfile, Data.class);
            log.info("getJsonData(): Data object has been successfully read from json file: " + content);
            database = content;
        } catch (JsonParseException e) {
            log.error("getJsonData(): Json parse (Jackson) failed.");
            e.printStackTrace();
        } catch (JsonMappingException e) {
            log.error("getJsonData(): Json mapper (Jackson) failed.");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("getJsonData(): Writing to json failed.");
            e.printStackTrace();
        }

        return content;
    }

}
