package com.pipe42.data;

import com.pipe42.util.Util;

import java.util.HashMap;

/**
 * This class is the facade for our POJO objects
 */
public class PojoConstructor {

    public Project buildProjectObject(String projectName, String projectPrefix, String ownerID, String engineID,
                                      String appID, String projectNotes) {

        // get a unique hash ID
        String id = Util.getHash(projectName);

        // get formatted datetime
        HashMap<String, String> modifyTime = Util.getDateTime();

        return new Project(id, projectName, projectPrefix, ownerID, engineID, appID,
                creationTime, modifyTime, projectNotes);
    }

}
