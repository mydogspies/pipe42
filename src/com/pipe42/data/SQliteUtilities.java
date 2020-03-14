package com.pipe42.data;

import com.pipe42.data.pojos.PojoParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

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
    public static void createTableFromPojo(Object pojo) {

        // parse the object, get fields and class name
        //
        List<String> fieldList =  PojoParser.parsePojoFieldsAndClass(pojo);
        String query = "";

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
        }


        // open connection and execute query
        //

        DatabaseSQLite db = new DatabaseSQLite();

        Map<String, Object> connectionObject = db.connectToSQlite();

        Connection con = (Connection) connectionObject.get("connection");
        Statement stmt = (Statement) connectionObject.get("statement");

        try {
            // con = DriverManager.getConnection("jdbc:sqlite:" + uri);
            log.info("createTableFromPojo(): Successfully connected to database: " + con);
            stmt.executeUpdate(query);
            db.closeSQliteConnection(connectionObject);
        } catch (SQLException e) {
            log.warn("createTableFromPojo(): Connection to database failed.");
        }
    }

    /*public String findPrimaryKeyName(String tableName) {

        Map<String, Object> con = connectToSQlite();

        Statement stmt = (Statement)con.get("statement");
        String string = "";
        String idString = "";

        String searchQuery = "SELECT sql FROM sqlite_master WHERE tbl_name ='" + tableName.toUpperCase() + "' AND type='table'";
        log.trace("findPrimaryKeyName(): Search query: " +searchQuery);

        try {
            // we literally find the name of the ID field in the table by looking specifically
            // for the fields that contains "(*ID" which in our case, as long as we stick to
            // our specific POJO structure, will return the correct ID field.
            ResultSet rs = stmt.executeQuery(searchQuery);
            string = rs.getString(1);
            String pattern = "(\\B\\(\\w*)";
            Pattern pat = Pattern.compile(pattern);
            Matcher match = pat.matcher(string);

            while (match.find()) {
                idString = match.group(1);
            }

            idString = idString.substring(1);
            log.trace("findPrimaryKeyName(): Pattern found: " + idString);
            closeSQliteConnection(con);
            return idString;

        } catch (SQLException e) {
            log.warn("findPrimaryKeyName(): No pattern found for: " + tableName + " in: " + string);
            closeSQliteConnection(con);
        }

        return null;

    }*/

    /**
     * Makes a connection to SQlite and returns a map with the Connection and Statement objects.
     * @return map with Connection and Statement objects, otherwise null
     */
    /*private Map<String, Object> connectToSQlite() {

        String uri = UserPreferences.userSettings.get("databaseSQLiteDataPath", "");

        Map<String, Object> cobj = new HashMap<>();

        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:sqlite:" + uri);
            log.info("createTableFromPojo(): Successfully connected to SQliteUtilities: " + con);
            stmt = con.createStatement();
            cobj.put("connection", con);
            cobj.put("statement", stmt);
            return cobj;
        } catch (SQLException e) {
            log.warn("createTableFromPojo(): Connection to SQllite failed.");
            return null;
        }
    }

    *//**
     * Simply closes the connection object and frees resources
     * @param connectionObject a map of objects - "connection":Connection object and "statement":Statement object
     *//*
    private void closeSQliteConnection(Map<String, Object> connectionObject) {

        Connection con = (Connection)connectionObject.get("connection");
        Statement stmt = (Statement)connectionObject.get("statement");

        try {
            stmt.close();
            con.close();
            log.trace("closeSQliteConnection(): Connection closed.");
        } catch (SQLException e) {
            log.warn("closeSQliteConnection(): Connection could not be closed.");
        }
    }*/

}
