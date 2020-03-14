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
import java.util.ArrayList;
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
 *
 * @author Peter Mankowski
 * @see com.pipe42.data.DatabaseFactoryProvider
 * @see com.pipe42.data.DatabaseIO
 * @see com.pipe42.main.Main
 * @since 0.2.0
 */
public class DatabaseSQLite implements DatabaseIO {

    private static final Logger log = LoggerFactory.getLogger(DatabaseSQLite.class);

    // GENERAL METHODS //
    //

    /**
     * Reads the SQlite schema and returns a string with all the info.
     *
     * @return a string with data, otherwise and empty string
     */
    @Override
    public String getDatabaseInfo() {

        Map<String, Object> connectionObject = connectToSQlite();

        Connection con = (Connection) connectionObject.get("connection");
        Statement stmt = (Statement) connectionObject.get("statement");

        String searchQuery = "SELECT sql FROM sqlite_master";
        String result = "";

        try {
            ResultSet rs = stmt.executeQuery(searchQuery);
            result = rs.getString(1);
            log.trace("getDatabaseInfo(): Info found: " + result);
        } catch (SQLException e) {
            log.info("getDatabaseInfo(): No info found.");
        }

        return result;
    }

    /**
     * Takes the Data object and writes all the contents into separate tables.
     *
     * @param data an object
     * @return true if written, otherwise null // TODO should really become void?
     */
    @Override
    public Boolean writeAll(Data data) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTableRow(data.getProject(), con);
            writeTableRow(data.getOwner(), con);
            writeTableRow(data.getApplication(), con);
            writeTableRow(data.getEngine(), con);
            closeSQliteConnection(con);
        }

        return null;
    }

    /**
     * Makes a connection to SQlite and returns a map with the Connection and Statement objects.
     *
     * @return map with Connection and Statement objects, otherwise null
     */ // TODO make private after testing
    public Map<String, Object> connectToSQlite() {

        String uri = UserPreferences.userSettings.get("databaseSQLiteDataPath", "");

        Map<String, Object> cobj = new HashMap<>();

        Connection con = null;
        Statement stmt = null;

        try {
            con = DriverManager.getConnection("jdbc:sqlite:" + uri);
            log.info("connectToSQlite(): Successfully connected to SQlite: " + con);
            stmt = con.createStatement();
            cobj.put("connection", con);
            cobj.put("statement", stmt);
            log.trace("connectToSQlite(): Connection object returned: " + cobj);
            return cobj;
        } catch (SQLException e) {
            log.warn("connectToSQlite(): Connection to SQlite failed.");
            ;
            return null;
        }
    }

    /**
     * Simply closes the connection object and frees resources
     *
     * @param connectionObject a map of objects - "connection":Connection object and "statement":Statement object
     */ // TODO make private after testing
    public void closeSQliteConnection(Map<String, Object> connectionObject) {

        Connection con = (Connection) connectionObject.get("connection");
        Statement stmt = (Statement) connectionObject.get("statement");

        try {
            stmt.close();
            con.close();
            log.trace("closeSQliteConnection(): Connection closed: " + connectionObject);
        } catch (SQLException e) {
            log.warn("closeSQliteConnection(): Connection could not be closed.");
        }
    }

    /**
     * This method finds out the name of the primary key in our POJOS.
     * We find the name of the ID field in the table by looking specifically
     * for the fields that contains "(*ID" which in our case, as long as we stick to
     * our specific POJO structure, will return the correct ID field.
     *
     * @param tableName        the name of the table
     * @param connectionObject a map of objects - "connection":Connection object and "statement":Statement object
     * @return the name of the primary key
     */
    public String findPrimaryKeyName(String tableName, Map<String, Object> connectionObject) {

        Statement stmt = (Statement) connectionObject.get("statement");
        String string = "";
        String idString = "";

        String searchQuery = "SELECT sql FROM sqlite_master WHERE tbl_name ='" + tableName.toUpperCase() + "' AND type='table'";
        log.trace("findPrimaryKeyName(): Search query: " + searchQuery);

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
            return idString;

        } catch (SQLException e) {
            log.warn("findPrimaryKeyName(): No pattern found for: " + tableName + " in: " + string);
        }

        return null;

    }

    /**
     * Inserts or updates a SQlite with the passed POJO and connection object.
     * POJO fields have to correspond to the database columns. Connection object must
     * contain an open Connection to the database.
     *
     * @param pojo             a POJO object
     * @param connectionObject a map with a Connection object under the key "connection"
     */
    private void writeTableRow(Object pojo, Map<String, Object> connectionObject) {

        Connection con = (Connection) connectionObject.get("connection");
        String method = "insert";

        // parse the object and get the values
        Map<String, String> appMap = PojoParser.parsePojoToMap(pojo);
        log.trace("writeTableRow(): Incoming POJO map: " + appMap);

        // get the field names
        List<String> fieldList = PojoParser.parsePojoFieldsAndClass(pojo);
        log.trace("writeTableRow(): Incoming list of fields: " + fieldList);

        // SQL METHOD CHECK
        //
        try {
            String q = "SELECT * FROM " + fieldList.get(0).toUpperCase() + " WHERE " + fieldList.get(1) + "=?";
            PreparedStatement checkForTable = con.prepareStatement(q);
            checkForTable.setString(1, appMap.get(fieldList.get(1)));
            ResultSet rs = checkForTable.executeQuery();
            log.trace("writeTableRow(): Checking existence of ID using query: " + q);
            if (rs.next()) {
                method = "UPDATE";
            } else {
                method = "INSERT";
            }
            log.debug("writeTableRow(): Check if exists: Method will be " + method);
        } catch (SQLException e) {
            log.warn("writeTableRow(): Error reading table " + fieldList.get(0));
        }

        // INSERT vs UPDATE
        //
        switch (method) {
            case "INSERT":

                // build a string
                String query = "INSERT INTO " + fieldList.get(0).toUpperCase() + " (";
                String append = "";

                for (int i = 1; i < fieldList.size(); i++) {
                    query = query + fieldList.get(i).toUpperCase() + ", ";
                    append = append + "?, ";
                }
                query = query.substring(0, query.length() - 2) + ") VALUES (" + append.substring(0, append.length() - 2) + ")";

                log.trace("writeTableRow(): Query string constructed: " + query);

                // put together statement
                try {
                    PreparedStatement insertApplication = con.prepareStatement(query);

                    for (int j = 1; j < fieldList.size(); j++) {
                        insertApplication.setString(j, appMap.get(fieldList.get(j)));
                        log.trace("writeTableRow(): insertApplication in PreparedStatement with parameters: " + j + ", " + appMap.get(fieldList.get(j)));
                    }
                    insertApplication.executeUpdate();
                    log.info("writeTableRow(): Successfully inserted in SQlite table: " + query);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    log.warn("writeTableRow(): Writing to SQlite table failed.");
                }
                break;

            case "UPDATE":

                // build a string
                String query2 = "UPDATE " + fieldList.get(0).toUpperCase() + " SET ";

                for (int k = 2; k < fieldList.size(); k++) {
                    query2 = query2 + fieldList.get(k).toUpperCase() + "=?, ";
                }
                query2 = query2.substring(0, query2.length() - 2) + " WHERE " + fieldList.get(1) + "='" + appMap.get(fieldList.get(1)) + "'"; // TODO hard coded apostrophes! Not good! Fix after testing
                log.trace("writeTableRow(): Query string constructed: " + query2);

                // put together statement
                try {
                    PreparedStatement updateApplication = con.prepareStatement(query2);
                    for (int n = 1; n < fieldList.size() - 1; n++) {
                        updateApplication.setString(n, appMap.get(fieldList.get(n + 1)));
                        log.trace("writeTableRow(): insertApplication in PreparedStatement with parameters: " + n + ", " + appMap.get(fieldList.get(n + 1)));
                    }
                    updateApplication.executeUpdate();
                    log.info("writeTableRow(): Successfully updated SQlite table: " + query2);
                } catch (SQLException e) {
                    log.warn("writeTableRow(): Writing to SQlite table failed:");
                }

                break;
        }
    }

    /**
     * Delete a table in the SQlite database based on its name
     *
     * @param tableName        name of the table case independent
     * @param connectionObject a map with Statement and Connection objects; "connection":Connection object and "statement":Statement object
     */
    private void deleteTable(String tableName, Map<String, Object> connectionObject) {

        Connection stmt = (Connection) connectionObject.get("statement");
        String query = "DELETE " + tableName.toUpperCase();

        log.trace("deleteTable(): Incoming table name string: " + tableName);

        try {
            stmt.createStatement();
            stmt.prepareStatement(query);
            log.info("deleteTable(): The table " + tableName.toUpperCase() + " has been deleted: " + query);
        } catch (SQLException e) {
            log.warn("deleteTable(): The table could not be deleted: " + tableName);
        }
    }

    /**
     * Takes an unique ID of a row in a table and together with a connection object deletes that row permanently.
     *
     * @param id               the unique row ID
     * @param tableName        the name of the table the row is in
     * @param connectionObject a map with Statement and Connection objects; "connection":Connection object and "statement":Statement object
     */
    private void deleteTableRow(String id, String tableName, Map<String, Object> connectionObject) {

        Statement stmt = (Statement) connectionObject.get("statement");
        String string = "";
        String idString = "";

        String searchQuery = "SELECT sql FROM sqlite_master WHERE tbl_name ='" + tableName + "' AND type='table'";
        log.trace("deleteRow(): Search query: " + searchQuery);

        idString = findPrimaryKeyName(tableName, connectionObject);

        // and then do the deletion magic
        String deleteQuery = "DELETE FROM " + tableName + " WHERE " + idString + "='" + id + "'";
        try {
            stmt.executeUpdate(deleteQuery);
            log.info("deleteRow(): The row with id " + id + " has been deleted from " + tableName);
        } catch (SQLException e) {
            log.warn("deleteRow(): Could not delete " + id + " from " + tableName);
        }

    }

    /**
     * Takes a table name, a string with columns, a search term and a connection object the returns a ResultSet of data.
     * Note: the string of columns and the search terms must be in SQL syntax, eg. "appID, appName" and "appName='SomeAppName'".
     *
     * @param tableName        the name of the table, which is the same as our POJO class names
     * @param columns          a SQL syntax term, eg. "appID, appName, notes"
     * @param searchTerms      a SQL syntax term, eg. "appOnwer='Michael' AND appName='Maya'".
     * @param connectionObject a map with Statement and Connection objects; "connection":Connection object and "statement":Statement object
     * @return a result set
     */ // TODO make this private after test!!!
    public ResultSet searchTableForRows(String tableName, String columns, String searchTerms, String orderBy, Map<String, Object> connectionObject) {

        Connection con = (Connection) connectionObject.get("connection");
        Statement stmt = (Statement) connectionObject.get("statement");

        ResultSet rs = null;
        String query = "";

        if (!searchTerms.equals("")) {
            query = "SELECT " + columns + " FROM " + tableName + " WHERE " + searchTerms + " ORDER BY " + orderBy;
            log.trace("searchTableForRows(): Query string constructed: " + query);
            try {
                PreparedStatement search = con.prepareStatement(query);
                rs = search.executeQuery();
                log.trace("searchTableForRows(): Executed query: SELECT " + columns + " FROM " + tableName + " WHERE " + searchTerms + " ORDER BY " + orderBy);
                System.out.println(rs.getString(1));
            } catch (SQLException e) {
                log.warn("searchTableForRows(): Could not execute query using string: SELECT " + columns + " FROM " + tableName + " WHERE " + searchTerms + " ORDER BY " + orderBy);
            }
        } else {
            query = "SELECT " + columns + " FROM " + tableName + " ORDER BY " + orderBy;
            log.trace("searchTableForRows(): Query string constructed: " + query);
            try {
                PreparedStatement search = con.prepareStatement(query);
                rs = search.executeQuery();
                log.trace("searchTableForRows(): Executed query: SELECT " + columns + " FROM " + tableName + " ORDER BY " + orderBy);
            } catch (SQLException e) {
                log.warn("searchTableForRows(): Could not execute query using string: SELECT " + columns + " FROM " + tableName + " ORDER BY " + orderBy);
            }
        }

        return rs;
    }

    // PROJECT METHODS
    //

    /**
     * List all rows in table PROJECT
     *
     * @return a list of Project objects
     */
    @Override
    public List<Project> getAllProjects() {

        Map<String, Object> con = connectToSQlite();
        PojoConstructor pc = new PojoConstructor();

        ResultSet rs;
        List<Project> projectList = new ArrayList<>();

        if (con != null) {
            rs = searchTableForRows("PROJECT", "*", "", "PROJECTNAME", con);

            while (true) {

                try {
                    if (!rs.next()) break;

                    // construct the a project object using our PojoConstructor for the sake of consistency
                    Project project = pc.listProjectObject(rs.getString("PROJECTID"), rs.getString("PROJECTNAME"),
                            rs.getString("PROJECTPREFIX"),
                            rs.getString("OWNERID"), rs.getString("ENGINEID"),
                            rs.getString("APPLICATIONID"), rs.getString("NOTES"),
                            rs.getString("PROJECTTEMPLATE"), rs.getString("PROJECTPATH"),
                            rs.getString("CREATIONTIME"), rs.getString("MODIFYTIME"));
                    projectList.add(project);
                    log.debug("getAllProjects(): Returned a list of Project objects: " + rs);
                    closeSQliteConnection(con);
                    return projectList;
                } catch (SQLException e) {

                    log.warn("getAllProjects(): Could not read the result file: " + rs);
                }

            }

            closeSQliteConnection(con);
        }

        return null;
    }

    @Override
    public Project getProjectByID(String id) {

        Map<String, Object> con = connectToSQlite();
        PojoConstructor pc = new PojoConstructor();

        ResultSet rs;

        if (con != null) {
            rs = searchTableForRows("PROJECT", "*", "PROJECTID='" + id + "'", "''", con);

            try {

                // construct the a project object using our PojoConstructor for the sake of consistency
                Project project = pc.listProjectObject(rs.getString("PROJECTID"), rs.getString("PROJECTNAME"),
                        rs.getString("PROJECTPREFIX"),
                        rs.getString("OWNERID"), rs.getString("ENGINEID"),
                        rs.getString("APPLICATIONID"), rs.getString("NOTES"),
                        rs.getString("PROJECTTEMPLATE"), rs.getString("PROJECTPATH"),
                        rs.getString("CREATIONTIME"), rs.getString("MODIFYTIME"));
                log.debug("ProjectByID(): Returned a list of Project objects: " + rs);
                closeSQliteConnection(con);
                return project;
            } catch (SQLException e) {

                log.warn("ProjectByID(): Could not read the result file: " + rs);
            }

            closeSQliteConnection(con);
        }

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

    /**
     * Writes a new project into the SQlite database.
     * This is in this case equivalent to the writeProject() method
     * thus we simply call pass it over.
     *
     * @param project an object
     */
    @Override
    public void updateProject(Project project) {

        log.trace("updateProject(): Forwarded project object: " + project + "");

        writeProject(project);
    }

    /**
     * Inserts or updates the SQlite database with an Project object
     *
     * @param project an object
     */
    @Override
    public void writeProject(Project project) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            log.trace("writeProject(): Sent of object to writing: " + project + " - with connection object: " + con);
            writeTableRow(project, con);
            closeSQliteConnection(con);
        }
    }

    /**
     * Deletes a row based on its unique ID
     *
     * @param id a unique hash ID
     */
    @Override
    public void deleteProject(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteTableRow(id, "PROJECT", con);
            closeSQliteConnection(con);
        }
    }


    // OWNER METHODS
    //

    /**
     * Lists all rows in the table OWNER
     *
     * @return A list of Owner objects
     */
    @Override
    public List<Owner> getAllOwners() {

        Map<String, Object> con = connectToSQlite();

        ResultSet rs = null;
        List<Owner> ownerList = new ArrayList<>();

        if (con != null) {
            rs = searchTableForRows("OWNER", "*", "", "OWNERNAME", con);
            while (true) {
                try {
                    if (!rs.next()) break;
                    Owner owner = new Owner();
                    owner.setOwnerId(rs.getString("OWNERID"));
                    owner.setOwnerName(rs.getString("OWNERNAME"));
                    owner.setOwnerCompany(rs.getString("OWNERCOMPANY"));
                    owner.setOwnerDepartment(rs.getString("OWNERDEPARTMENT"));
                    owner.setProjectManager(rs.getString("PROJECTMANAGER"));
                    owner.setNotes(rs.getString("NOTES"));
                    ownerList.add(owner);
                    log.warn("getAllOwners(): Returned a list of Owner objects: " + rs);
                    closeSQliteConnection(con);
                    return ownerList;
                } catch (SQLException e) {
                    log.warn("getAllOwners(): Could not read the result file: " + rs);
                }

            }
            closeSQliteConnection(con);
        }
        return null;
    }

    /**
     * Inserts or updates the SQlite database with an Owner object
     *
     * @param owner an object
     */
    @Override
    public void writeOwner(Owner owner) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTableRow(owner, con);
            closeSQliteConnection(con);
        }
    }

    /**
     * Deletes a row based on its unique ID
     *
     * @param id a unique hash ID
     */
    @Override
    public void deleteOwner(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteTableRow(id, "OWNER", con);
            closeSQliteConnection(con);
        }
    }


    // APPLICATION METHODS
    //

    /**
     * List all rows in table APPLICATION
     *
     * @return list of Application objects
     */
    @Override
    public List<Application> getAllApps() {

        Map<String, Object> con = connectToSQlite();

        ResultSet rs = null;
        List<Application> appList = new ArrayList<>();

        if (con != null) {
            rs = searchTableForRows("APPLICATION", "*", "", "APPNAME", con);
            while (true) {
                try {
                    if (!rs.next()) break;
                    Application app = new Application();
                    app.setAppID(rs.getString("APPID"));
                    app.setAppName(rs.getString("APPNAME"));
                    app.setAppVersion(rs.getString("APPVERSION"));
                    app.setAppPathToExecutable(rs.getString("APPPATHTOEXECUTABLE"));
                    app.setAppExecParams(rs.getString("APPEXECPARAMS"));
                    app.setNotes(rs.getString("NOTES"));
                    appList.add(app);
                    log.warn("getAllApps(): Returned a list of Application objects: " + rs);
                    closeSQliteConnection(con);
                    return appList;
                } catch (SQLException e) {
                    log.warn("getAllApps(): Could not read the result file: " + rs);
                }

            }
            closeSQliteConnection(con);
        }
        return null;
    }

    /**
     * Inserts or updates the SQlite database with an Application object
     *
     * @param appData an object
     */
    @Override
    public void writeApplication(Application appData) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTableRow(appData, con);
            closeSQliteConnection(con);
        }
    }

    /**
     * Deletes a row with the unique row ID
     *
     * @param id unique ID of row
     */
    @Override
    public void deleteApplication(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteTableRow(id, "APPLICATION", con);
            closeSQliteConnection(con);
        }
    }


    // RENDERENGINE METHODS
    //

    /**
     * List all rows in the table RENDERENGINE
     *
     * @return a list of Renderengine objects
     */
    @Override
    public List<Renderengine> getAllEngines() {

        Map<String, Object> con = connectToSQlite();

        ResultSet rs = null;
        List<Renderengine> renderList = new ArrayList<>();

        if (con != null) {
            rs = searchTableForRows("RENDERENGINE", "*", "", "ENGINENAME", con);
            while (true) {
                try {
                    if (!rs.next()) break;
                    Renderengine rend = new Renderengine();
                    rend.setEngineID(rs.getString("ENGINEID"));
                    rend.setEngineName(rs.getString("ENGINENAME"));
                    rend.setEnginePathToExecutable(rs.getString("ENGINEPATHTOEXECUTABLE"));
                    rend.setEngineExecParams(rs.getString("ENGINEEXECPARAMS"));
                    rend.setEngineVersion(rs.getString("ENGINEVERSION"));
                    rend.setNotes(rs.getString("NOTES"));
                    renderList.add(rend);
                    log.warn("getAllEngines(): Returned a list of Renderengine objects: " + rs);
                    closeSQliteConnection(con);
                    return renderList;
                } catch (SQLException e) {
                    log.warn("getAllEngines(): Could not read the result file: " + rs);
                }

            }
            closeSQliteConnection(con);
        }
        return null;

    }

    /**
     * Inserts or updates the SQlite database with an Renderengine object
     *
     * @param engine an object
     */
    @Override
    public void writeRenderengine(Renderengine engine) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            writeTableRow(engine, con);
            closeSQliteConnection(con);
        }
    }

    /**
     * Deletes a row with the unique row ID
     *
     * @param id unique ID of row
     */
    @Override
    public void deleteRenderengine(String id) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            deleteTableRow(id, "RENDERENGINE", con);
            closeSQliteConnection(con);
        }
    }

    // ASSET METHODS
    //


}
