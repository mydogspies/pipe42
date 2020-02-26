package com.pipe42.data;

import com.pipe42.util.Util;

import java.util.HashMap;

/**
 * This class is the facade for our POJO objects
 */
public class PojoConstructor {

    /**
     * Puts together the Project object
     * @param projectName name o project of type String
     * @param projectPrefix project prefix of type String
     * @param ownerID owner ID of type String
     * @param engineID renderengine ID of type String
     * @param appID application ID of type String
     * @param projectNotes project notes of type String
     * @return an instance of the Project object
     */
    public Project buildProjectObject(String projectName, String projectPrefix, String ownerID, String engineID,
                                      String appID, String projectNotes) {

        // TODO here will authentication of the data before processing go

        // get a unique hash ID
        String id = Util.getHash(projectName);

        // get formatted datetime
        HashMap<String, String> modifyTime = Util.getDateTime();

        // check of project already exists and if not the construct a creationTime
        JsonDataIO io = new JsonDataIO();
        Project result = null;
        HashMap<String, String> creationTime = null;
        result = io.getProjectByName(projectName);
        if (result != null) {
            creationTime = result.getCreationTime();
        } else {
            creationTime = Util.getDateTime();
        }

        return new Project(id, projectName, projectPrefix, ownerID, engineID, appID,
                creationTime, modifyTime, projectNotes);
    }

}
