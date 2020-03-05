package com.pipe42.data;

import com.pipe42.data.pojos.PojoParser;
import com.pipe42.prefs.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * This class contains all the SQliteUtilities specific methods that are a bit too esoteric to fit into default SQliteUtilities factory.
 * @author Peter Mankowski
 * @since 0.2.0
 */
public class SQliteUtilities {

    private static final Logger log = LoggerFactory.getLogger(SQliteUtilities.class);

    /**
     * This method inserts a table into SQliteUtilities based on the field names of our POJOS.
     * NOTE! It follows the following convention;
     * a) All fields in the database are strings
     * b) Index [1] in the list is always the first field and contains the unique ID. This will be set as primary key.
     * c) The field containing notes and comments is always called "notes", otherwise it will not be set to TEXT, only to a varchar(255).
     * @param pojo a pojo object
     * @return true if success, otherwise null
     */
    public static Boolean createTableFromPojo(Object pojo) {

        // parse the object, get fields and class name
        //
        List<String> fieldList =  PojoParser.parsePojoFieldsAndClass(pojo);
        String uri = UserPreferences.userSettings.get("databaseSQLiteDataPath", "");
        String query;

        // create the query
        //
        if (!(fieldList != null && fieldList.isEmpty())) {
            query = "CREATE TABLE " + fieldList.get(0).toUpperCase() + " (";

            for (int i = 1; i < fieldList.size(); i++) {
                if (i == 1) {
                    query = query + fieldList.get(i).toUpperCase() + " VARCHAR(6) PRIMARY KEY NOT NULL, ";
                } else {
                    if (!fieldList.get(i).contains("notes")) {
                        query = query + fieldList.get(i).toUpperCase() + " VARCHAR(255), ";
                    } else {
                        query = query + fieldList.get(i).toUpperCase() + " TEXT, ";
                    }
                }
            }
            query = query.substring(0, query.length() - 2) + ")";
            log.trace("createTableFromPojo(): Table created from pojo (" + pojo +"): " + fieldList);
        } else {
            log.warn("createTableFromPojo(): List returned is empty.");
            return null;
        }


        // open connection and execute query
        //

        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:sqlite:" + uri);
            log.info("createTableFromPojo(): Successfully connected to SQliteUtilities: " + con);
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
            return true;
        } catch (SQLException e) {
            log.warn("createTableFromPojo(): Connection to SQliteUtilities failed.");
            e.printStackTrace();
        }

        return null;
    }

}
