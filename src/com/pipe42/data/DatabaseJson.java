package com.pipe42.data;


import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pipe42.console.ConsoleOut;
import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Data;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;
import com.pipe42.main.Initialize;

// TODO Branch: develop-factory / this is the implementation of DatabaseIO interface - once plugged into the main code, take this notice away!

/**
 * IO and call logic for json files as database
 * @author Peter Mankowski
 *
 */
public class DatabaseJson implements DatabaseIO {

    // TODO below code is obsolete?
    // NOTE: path is relative from root, eg. src/....
    // private static String rawPath = UserPreferences.userSettings.get("databaseJsonDataPath", "");

    // The current parse of the json file
    // this is always set by getJsonData()
    private static Data database;

    /* CONSTRUCTORS */

    public DatabaseJson() {
        database = getJsonData();
    }

    /* IMPLEMENTED METHODS */

    @Override
    public String getDatabaseInfo() {

        // TODO implement the info properly

        return "Json";
    }

    // PROJECT METHODS
    //

    /**
     * Takes an ID and returns a Project object if it equals the project ID of an existing Project
     * @param id project ID of type String
     * @return the Project object, otherwise NULL
     */
    @Override
    public Project getProjectByID(String id) {

        Project result = null;

        List<Project> projectList = database.getProject();

        for (Project project: projectList) {
            if (project.getProjectID().equals(id)) {
                result = project;
            }
        }

        return result;
    }

    /**
     * Takes a string and returns a Project object if it equals the name of an existing Project
     * Note that this is case independent
     * @param name name of a project with type String
     * @return a Project object or null when none
     */
    @Override
    public Project getProjectByName(String name) {

        Project result = null;

        List<Project> projectList = database.getProject();

        for (Project project: projectList) {
            if (project.getProjectName().toLowerCase().equals(name.toLowerCase())) {
                result = project;
            }
        }

        return result;
    }

    /**
     * Returns a list of all projects
     * @return a list of type List with all project objects of type Project
     */
    @Override
    public List<Project> getAllProjects() {

        return database.getProject();
    }

    @Override
    public String getPrefixByName(String prefix) {

        String result = null;

        List<Project> projectList = database.getProject();

        for (Project project: projectList) {
            if (project.getProjectPrefix().toLowerCase().equals(prefix.toLowerCase())) {
                result = project.getProjectPrefix();
            }
        }

        return result;
    }

    /**
     * Appends an entry of type Project into the data.json file
     * @param project list of entries of type Project
     */
    @Override
    public void writeProject(Project project) {

        // get current database from json.data
        Data database = getJsonData();

        // and then add it to current list of Application objects
        List<Project> projectList = database.getProject();
        projectList.add(project);

        Data container = new Data(projectList, database.getApplication(), database.getOwner(), database.getEngine());

        writeJsonData(container);
    }

    /**
     * Deletes a project from the database based on its hash ID
     * @param id hash id string of type String
     */
    @Override
    public void deleteProject(String id) {

        // get current db from json
        Data database = getJsonData();

        // list all projects, find the right one and delete it
        List<Project> projectList = database.getProject();
        projectList.removeIf(project -> project.getProjectID().equals(id));

        Data container = new Data(projectList, database.getApplication(), database.getOwner(), database.getEngine());

        writeJsonData(container);
    }


    // OWNER METHODS
    //

    /**
     * Get all Owner objects and return a List thereof
     * @return returns a List of type Owner
     */
    @Override
    public List<Owner> getAllOwners() {

        // Data database = getJsonData();
        return database.getOwner();
    }

    @Override
    public void deleteQwner(String id) {
        // TODO add deleteOwner method
    }

    /**
     * Appends an entry of type Owner into the data.json file
     * @param owner list of entries of type Owner
     */
    @Override
    public void writeOwner(Owner owner) {

        // get current database from json.data
        Data database = getJsonData();

        // and then add it to current list of Application objects
        List<Owner> ownerList = database.getOwner();
        ownerList.add(owner);

        Data container = new Data(database.getProject(), database.getApplication(), ownerList, database.getEngine());

        writeJsonData(container);
    }


    // APPLICATION METHODS
    //

    /**
     * Get all Application objects and return a List thereof
     * @return returns List of type Application
     */
    @Override
    public List<Application> getAllApps() {

        // Data database = getJsonData();
        return database.getApplication();
    }

    /**
     * Appends an entry of type Application into the data.json file
     * @param appData list of entries of type Application
     */
    @Override
    public void writeApplication(Application appData) {

        // get current database from json.data
        Data database = getJsonData();

        // and then add it to current list of Application objects
        List<Application> appList = database.getApplication();
        appList.add(appData);

        Data container = new Data(database.getProject(), appList, database.getOwner(), database.getEngine());

        writeJsonData(container);
    }

    @Override
    public void deleteApplication(String id) {
        // TODO add deleteApplication method
    }


    // RENDERENGINE METHODS
    //

    /**
     * Get all Renderengine objects and return a List thereof
     * @return returns List of type Renderengine
     */
    @Override
    public List<Renderengine> getAllEngines() {

        // Data database = getJsonData();
        return database.getEngine();
    }

    @Override
    public void deleteRenderengine(String id) {
        // TODO add deleteRenderengine method
    }

    /**
     * Appends an entry of type Renderengine into the data.json file
     * @param engine list of entries of type Renderengine
     */
    @Override
    public void writeRenderengine(Renderengine engine) {

        // get current database from json.data
        Data database = getJsonData();

        // and then add it to current list of Application objects
        List<Renderengine> engineList = database.getEngine();
        engineList.add(engine);

        Data container = new Data(database.getProject(), database.getApplication(), database.getOwner(), engineList);

        writeJsonData(container);
    }


    /* LOCAL METHODS */

    /**
     * Constructs a Json file (overwrites) with data contained in the Data object
     * in the path defined by getFileJson
     * @param data an object of type Data
     */
    public void writeJsonData(Data data) { // TODO change to private when tests done

        FileWorks fw = new FileWorks();
        File jsonfile = fw.readJsonFile("data.json");

        // and write the new Data object to json.data
        try {
            Initialize.mapper.writeValue(jsonfile, data);
            ConsoleOut.printCons("Data successfully written to Json file");
        } catch (JsonParseException e) {
            ConsoleOut.printCons("Json parser failed");
            // TODO - JsonData - add logging
            e.printStackTrace();
        } catch (JsonMappingException e) {
            ConsoleOut.printCons("Json mapper failed");
            // TODO - JsonData - add logging
            e.printStackTrace();
        } catch (IOException e) {
            ConsoleOut.printCons("Writing to json file failed");
            // TODO - JsonData - add logging
            e.printStackTrace();
        }

    }

    /**
     * Reads the json.data file and returns a Data object with the entire object
     * @return an object of type Data
     */
    private Data getJsonData() {

        Data content = null;
        FileWorks fw = new FileWorks();

        File jsonfile = fw.readJsonFile("data.json");

        try {
            content = Initialize.mapper.readValue(jsonfile, Data.class);
            ConsoleOut.printCons("Data successfully read from Json file.");
            database = content;
        } catch (JsonParseException e) {
            ConsoleOut.printCons("Json parser failed");
            // TODO - JsonData - add logging
            e.printStackTrace();
        } catch (JsonMappingException e) {
            ConsoleOut.printCons("Json mapper failed");
            // TODO - JsonData - add logging
            e.printStackTrace();
        } catch (IOException e) {
            ConsoleOut.printCons("Reading from json file failed");
            // TODO - JsonData - add logging
            e.printStackTrace();
        }

        return content;
    }

}
