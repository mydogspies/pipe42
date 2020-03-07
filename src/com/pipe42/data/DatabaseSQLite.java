package com.pipe42.data;

import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Data;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.PojoParser;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;
import com.pipe42.prefs.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * These are all the methods relating to implementing SQliteUtilities as a database.
 * This class should not be called directly. Instead use the {@com.pipe42.data.DatabaseFactoryProvider} for that.
 * In this case the Main method initiates a "factory" object through which we can call any method independent
 * of the underlying database.
 * @author Peter Mankowski
 * @since 0.2.0
 * @see com.pipe42.data.DatabaseFactoryProvider
 * @see com.pipe42.data.DatabaseIO
 * @see com.pipe42.main.Main
 */
public class DatabaseSQLite implements DatabaseIO {

    private static final Logger log = LoggerFactory.getLogger(DatabaseSQLite.class);

    // GENERAL METHODS //
    //

    @Override
    public String getDatabaseInfo() {
        return null;
    }

    @Override
    public Boolean writeAll(Data data) {
        return null;
    }

    /**
     * Makes a connection to SQlite and returns a map with the Connection and Statement objects.
     * @return map with Connection and Statement objects, otherwise null
     */
    private Map<String, Object> connectToSQlite() {

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
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Simply closes the connection object and frees resources
     * @param connectionObject a map of objects - "connection":Connection object and "statement":Statement object
     */
    private void closeSQliteConnection(Map<String, Object> connectionObject) {

        Connection con = (Connection)connectionObject.get("connection");
        Statement stmt = (Statement)connectionObject.get("statement");

        try {
            stmt.close();
            con.close();
            log.trace("closeSQliteConnection(): Connection closed.");
        } catch (SQLException e) {
            log.warn("closeSQliteConnection(): Connection could not be closed.");
            e.printStackTrace();
        }
    }

    /**
     * Inserts or updates a SQlite with the passed POJO and connection object.
     * POJO fields have to correspond to the database columns. Connection object must
     * contain an open Connection to the database.
     * @param pojo a POJO object
     * @param connectionObject a map with a Connection object under the key "connection"
     * @return true if successful insert/update, otherwise null
     */
    private Boolean writeTable(Object pojo, Map<String, Object> connectionObject) {

        Connection con = (Connection)connectionObject.get("connection");
        String method = "insert";

        // parse the object and get the values
        Map<String, String> appMap = PojoParser.parsePojoToMap(pojo);
        log.trace("writeTable(): Incoming POJO map: " + appMap);

        // get the field names
        List<String> fieldList = PojoParser.parsePojoFieldsAndClass(pojo);
        log.trace("writeTable(): Incoming list of fields: " + fieldList);


        // SQL METHOD CHECK
        //
        try {
            String q = "SELECT * FROM " + fieldList.get(0).toUpperCase() + " WHERE " + fieldList.get(1) + "=?";
            PreparedStatement checkForTable = con.prepareStatement(q);
            checkForTable.setString(1, appMap.get(fieldList.get(1)));
            ResultSet rs = checkForTable.executeQuery();
            log.trace("writeTable(): Checking existence of ID using query: " + q);
            if (rs.next()) {
                method = "UPDATE";
            } else {
                method = "INSERT";
            }
            log.debug("writeTable(): Check if exists: Method will be " + method);
        } catch (SQLException e) {
            closeSQliteConnection(connectionObject);
            log.warn("writeTable(): Error reading table " + fieldList.get(0));
            e.printStackTrace();
        }

        // INSERT vs UPDATE
        //
        switch (method) {
            case "INSERT":

                // build a string
                String query = "INSERT INTO " + fieldList.get(0).toUpperCase() + " (";
                String append = "";

                for (int i=1; i < fieldList.size(); i++) {
                    query = query + fieldList.get(i).toUpperCase() + ", ";
                    append = append + "?, ";
                }
                query = query.substring(0, query.length() - 2) + ") VALUES (" + append.substring(0, append.length() - 2) + ")";

                log.trace("writeTable(): Query string constructed: " + query);

                // put together statement
                try {
                    PreparedStatement insertApplication = con.prepareStatement(query);

                    for (int j=1; j < fieldList.size(); j++) {
                        insertApplication.setString(j, appMap.get(fieldList.get(j)));
                        log.trace("writeTable(): insertApplication in PreparedStatement with parameters: " + j + ", " + appMap.get(fieldList.get(j)));
                    }
                    insertApplication.executeUpdate();
                    closeSQliteConnection(connectionObject);
                    log.info("writeTable(): Successfully inserted in SQlite table: " + query);
                    return true;
                } catch (SQLException e) {
                    closeSQliteConnection(connectionObject);
                    log.warn("writeTable(): Writing to SQlite table failed.");
                    e.printStackTrace();
                }
                break;

            case "UPDATE":

                // build a string
                String query2 = "UPDATE " + fieldList.get(0).toUpperCase() + " SET ";

                for (int k=2; k < fieldList.size(); k++) {
                    query2 = query2 + fieldList.get(k).toUpperCase() + "=?, ";
                }
                query2 = query2.substring(0, query2.length() - 2) + " WHERE " + fieldList.get(1) + "='" + appMap.get(fieldList.get(1)) + "'"; // TODO hard coded apostrophes! Not good! Fix after testing
                log.trace("writeTable(): Query string constructed: " + query2);

                // put together statement
                try {
                    PreparedStatement updateApplication = con.prepareStatement(query2);
                    for (int n=1; n < fieldList.size()-1; n++) {
                        updateApplication.setString(n, appMap.get(fieldList.get(n+1)));
                        log.trace("writeTable(): insertApplication in PreparedStatement with parameters: " + n + ", " + appMap.get(fieldList.get(n+1)));
                    }
                    updateApplication.executeUpdate();
                    closeSQliteConnection(connectionObject);
                    log.info("writeTable(): Successfully updated SQlite table: " + query2);
                    return true;
                } catch (SQLException e) {
                    closeSQliteConnection(connectionObject);
                    log.warn("writeTable(): Writing to SQlite table failed:");
                    e.printStackTrace();
                }

                break;
        }
        return null;
    }

    /**
     * Delete a table in the SQlite database based on its name
     * @param tableName name of the table case independent
     * @param connectionObject a map with Statement and Connection objects; "connection":Connection object and "statement":Statement object
     */
    private void deleteTable(String tableName, Map<String, Object> connectionObject) {

        Connection stmt = (Connection)connectionObject.get("statement");
        String query = "DELETE " + tableName.toUpperCase();

        log.trace("deleteTable(): Incoming table name string: " + tableName);

        try {
            stmt.createStatement();
            stmt.prepareStatement(query);
            closeSQliteConnection(connectionObject);
            log.info("deleteTable(): The table " + tableName.toUpperCase() + " has been deleted: " + query);
        } catch (SQLException e) {
            closeSQliteConnection(connectionObject);
            log.warn("deleteTable(): The table could not be deleted: " + tableName);
            e.printStackTrace();
        }
    }

    /**
     * Takes an unique ID of a row in a table and together with a connection object deletes that row permanently.
     * @param id the unique row ID
     * @param tableName the name of the table the row is in
     * @param connectionObject a map with Statement and Connection objects; "connection":Connection object and "statement":Statement object
     */
    public void deleteRow(String id, String tableName, Map<String, Object> connectionObject) {

        Statement stmt = (Statement)connectionObject.get("statement");
        String string = "";
        String idString = "";

        String searchQuery = "SELECT sql FROM sqlite_master WHERE tbl_name ='" + tableName + "' AND type='table'";

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
            log.trace("deleteRow(): Pattern found: " + idString);

            // and then do the deletion magic
            String deleteQuery = "DELETE FROM " + tableName + " WHERE " + idString + "='" + id + "'";
            try {
                stmt.executeUpdate(deleteQuery);
                closeSQliteConnection(connectionObject);
                log.info("deleteRow(): The row with id " + id + " has been deleted from " + tableName);
            } catch (SQLException e) {
                closeSQliteConnection(connectionObject);
                log.warn("deleteRow(): Could not delete " + id + " from " + tableName);
                e.printStackTrace();
            }

        } catch (SQLException e) {
            closeSQliteConnection(connectionObject);
            log.warn("deleteRow(): No pattern found for: " + tableName + " in: " + string);
            e.printStackTrace();
        }
    }

    // PROJECT METHODS
    //

    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Project getProjectByID(String id) {
        return null;
    }

    @Override
    public Project getProjectByName(String name) {
        return null;
    }

    @Override
    public Project getProjectByPrefix(String prefix) {
        return null;
    }

    @Override
    public void updateProject(Project project) {

        writeProject(project);

    }

    /**
     * Inserts or updates the SQlite database with an Project object
     * @param project an object
     */
    @Override
    public void writeProject(Project project) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTable(project, con);
        }

    }

    /**
     * Deletes a row based on its unique ID
     * @param id a unique hash ID
     */
    @Override
    public void deleteProject(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteRow(id, "PROJECT", con);
        }
    }


    // OWNER METHODS
    //

    @Override
    public List<Owner> getAllOwners() {
        return null;
    }

    /**
     * Inserts or updates the SQlite database with an Owner object
     * @param owner an object
     */
    @Override
    public void writeOwner(Owner owner) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTable(owner, con);
        }

    }

    /**
     * Deletes a row based on its unique ID
     * @param id a unique hash ID
     */
    @Override
    public void deleteOwner(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteRow(id, "OWNER", con);
        }
    }


    // APPLICATION METHODS
    //

    @Override
    public List<Application> getAllApps() {
        return null;
    }

    /**
     * Inserts or updates the SQlite database with an Application object
     * @param appData an object
     */
    @Override
    public void writeApplication(Application appData) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTable(appData, con);
        }

    }

    /**
     * Deletes a row with the unique row ID
     * @param id unique ID of row
     */
    @Override
    public void deleteApplication(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteRow(id, "APPLICATION", con);
        }

    }


    // RENDERENGINE METHODS
    //

    @Override
    public List<Renderengine> getAllEngines() {
        return null;
    }

    /**
     * Inserts or updates the SQlite database with an Renderengine object
     * @param engine an object
     */
    @Override
    public void writeRenderengine(Renderengine engine) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTable(engine, con);
        }

    }

    /**
     * Deletes a row with the unique row ID
     * @param id unique ID of row
     */
    @Override
    public void deleteRenderengine(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteRow(id, "ENGINE", con);
        }

    }

    // ASSET METHODS
    //


}
