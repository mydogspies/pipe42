package com.pipe42.data;

import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.main.Main;
import com.pipe42.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is the facade for our POJO objects. Use the methods below to construct the various data object
 * rather than doing it elsewhere or things like datetime and various validity checks will fail.
 *
 * @author Peter Mankowski
 * @see com.pipe42.data.pojos.Data
 * @since 0.1.0
 */
public class PojoConstructor {

    private static final Logger log = LoggerFactory.getLogger(PojoConstructor.class);

    /**
     * Puts together the Project object for further use elsewhere. This particular method assumes that you want
     * a brand new Project object with a new unique ID. If looking just to update an existing object, see updateProjectObject().
     *
     * @param projectName   name of project
     * @param projectPrefix project prefix
     * @param ownerID       owner ID
     * @param engineID      renderengine ID
     * @param appID         application ID
     * @param projectNotes  project notes and comments
     * @return a Project object
     */
    public Project buildProjectObject(String projectName, String projectPrefix, String ownerID, String engineID,
                                      String appID, String projectNotes, String folderTemplate, String folderPath) {

        // get a unique hash ID
        String id = Util.getHash(projectName);

        // get formatted datetime
        HashMap<String, String> modifyTime = Util.getDateTime();

        // check if project already exists and if not the construct a creationTime
        Project result = null;
        HashMap<String, String> creationTime = null;

        result = Main.factory.getIO().getProjectByName(projectName);

        if (result != null) {
            creationTime = result.getCreationTime();
        } else {
            creationTime = Util.getDateTime();
        }

        Project project = new Project(id, projectName, projectPrefix, ownerID, engineID, appID,
                creationTime, modifyTime, projectNotes, folderTemplate, folderPath);

        log.debug("buildProjectObject(): Returned a Project object: " + project);

        return project;
    }


    /**
     * This method assumes an existing Project object thus keeping project ID intact and just adding the
     * time of modification into the output object. If you are after creating a brand new unique Project
     * object, see buildProjectObject():
     *
     * @param id             unique ID of this project
     * @param projectName    name of project
     * @param projectPrefix  project prefix
     * @param ownerID        owner ID
     * @param engineID       renderengine ID
     * @param appID          application ID
     * @param projectNotes   project notes and comments
     * @param folderTemplate the name of the template
     * @param folderPath     the absolute path to the root of the project folders
     * @param creationTime   time of initial creation
     * @return a Project object
     */
    public Project updateProjectObject(String id, String projectName, String projectPrefix, String ownerID,
                                       String engineID, String appID, String projectNotes, String folderTemplate,
                                       String folderPath, HashMap<String, String> creationTime) {

        // get formatted datetime
        HashMap<String, String> modifyTime = Util.getDateTime();

        Project project = new Project(id, projectName, projectPrefix, ownerID, engineID, appID,
                creationTime, modifyTime, projectNotes, folderTemplate, folderPath);

        log.debug("updateProjectObject(): Returned a Project object: " + project);

        return project;
    }

    /**
     * This method assumes an existing Project object thus keeping all data intact and simply
     * turning a List of values into a Project object
     * see buildProjectObject() and updateProjectObject
     *
     * @param id             unique ID of this project
     * @param projectName    name of project
     * @param projectPrefix  project prefix
     * @param ownerID        owner ID
     * @param engineID       renderengine ID
     * @param appID          application ID
     * @param projectNotes   project notes and comments
     * @param folderTemplate the name of the template
     * @param folderPath     the absolute path to the root of the project folders
     * @param creationTime   time of initial creation
     * @return a Project object
     */
    public Project listProjectObject(String id, String projectName, String projectPrefix, String ownerID,
                                     String engineID, String appID, String projectNotes, String folderTemplate,
                                     String folderPath, String creationTime,
                                     String modifyTime) {

        log.trace("listProjectObject(): Incoming project ID: (" + id);

        HashMap<String, String> ct = stringMapToHashMap(creationTime);
        HashMap<String, String> mt = stringMapToHashMap(modifyTime);

        Project project = new Project(id, projectName, projectPrefix, ownerID, engineID, appID,
                ct, mt, projectNotes, folderTemplate, folderPath);

        log.debug("listProjectObject(): Returned a Project object (" + project + ") containing project ID: " + project.getProjectID());

        return project;
    }


    /**
     * Puts together the Project object for further use elsewhere. This particular method assumes that you want
     * a brand new Project object with a new unique ID. If looking just to update an existing object, see updateProjectObject().
     * @param projectName name of project
     * @param projectPrefix project prefix
     * @param ownerID owner ID
     * @param engineID renderengine ID
     * @param appID application ID
     * @param projectNotes project notes and comments
     * @return a Project object
     */
    /**
     * Puts together the Owner object for further use elsewhere. This particular method assumes that you want
     * a brand new object with a new unique ID. If looking just to update an existing object, see updateOwnerObject().
     *
     * @param ownerName       name of the owner/company
     * @param ownerCompany    optional name of the company
     * @param ownerDepartment optional name of the department
     * @param projectManager  optional name of a project manager
     * @param notes           notes and comments
     * @return an Owner object
     */
    public Owner buildOwnerObject(String ownerName, String ownerCompany, String ownerDepartment,
                                  String projectManager, String notes) {

        // get a unique hash ID
        String id = Util.getHash(ownerName);

        Owner project = new Owner(id, ownerName, ownerCompany, ownerDepartment, projectManager, notes);

        log.debug("buildOwnerObject(): Returned an Owner object: " + project);

        return project;
    }

    /**
     * Used specifically for converting those maps we store in our database as strings back to a proper HashMap
     *
     * @param storedMap a hash map that was simply stored as a string
     * @return a Map object
     */
    public static HashMap<String, String> stringMapToHashMap(String storedMap) {

        log.trace("stringMapToHashMap(): Incoming string: " + storedMap);

        HashMap<String, String> newMap = new HashMap<>();

        String pattern = "[{\\s}]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(storedMap);

        while (m.find()) {
            storedMap = storedMap.replace(m.group(0), "");
        }

        String[] splitString = storedMap.split(",");

        for (String values : splitString) {
            String[] pair = values.split("=");
            newMap.put(pair[0], pair[1]);
        }

        log.debug("stringMapToHashMap(): HasMap returned: " + newMap);
        return newMap;

    }

}
