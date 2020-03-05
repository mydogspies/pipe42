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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * These are all the methods relating to implementing SQliteUtilities as a database.
 * This class should not be called directly. Instead use the {@com.pipe42.data.DatabaseFactoryProvider} for that.
 * In this case the Main method initiates a "factory" object through which we can call any method independent
 * of the underlying database.
 * @author Peter Mankowski
 * @since 0.2.o
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
     * Inserts or updates a SQlite with the passed POJO and connection object.
     * POJO fields have to corespond to the database columns. Connection object must
     * contain an open Connection to the database.
     * @param pojo a POJO object
     * @param connectionObject a map with a Connection object under the key "connection"
     * @return true if successful insert/update, otherwise null
     */
    private Boolean writeTable(Object pojo, Map<String, Object> connectionObject) {

        Connection con = (Connection)connectionObject.get("connection");
        // Statement stmt = (Statement)connectionObject.get("statement");

        // parse the object and get the values
        Map<String, String> appMap = PojoParser.parsePojoToMap(pojo);

        // TODO add check if we need INSERT or UPDATE
        // build the query string
        List<String> fieldList = PojoParser.parsePojoFieldsAndClass(pojo);
        String query = "INSERT INTO " + fieldList.get(0).toUpperCase() + " (";
        String append = "";

        for (int i=1; i < fieldList.size(); i++) {
            query = query + fieldList.get(i).toUpperCase() + ", ";
            append = append + "?, ";
        }
        query = query.substring(0, query.length() - 2) + ") VALUES (" + append.substring(0, append.length() - 2) + ")";

        log.trace("writeTable(): Query string constructed: " + query);

        try {
            PreparedStatement insertApplication = con.prepareStatement(query);

            for (int j=1; j < fieldList.size(); j++) {
                insertApplication.setString(j, appMap.get(fieldList.get(j)));
                log.trace("writeTable(): insertApplication in PreparedStatement with parameters: " + j + ", " + appMap.get(fieldList.get(j)));
            }
            insertApplication.executeUpdate();
            // stmt.close();
            con.close();
            log.info("writeTable(): Successfully inserted in SQlite table APPLICATION: " + query);
            return true;
        } catch (SQLException e) {
            log.warn("writeTable(): Writing to SQlite table APPLICATION failed.");
            e.printStackTrace();
        }

        return null;
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
    public void updateProject(Project newProject) {

    }

    @Override
    public void writeProject(Project project) {

    }

    @Override
    public void deleteProject(String id) {

    }


    // OWNER METHODS
    //

    @Override
    public List<Owner> getAllOwners() {
        return null;
    }

    @Override
    public void writeOwner(Owner owner) {

    }

    @Override
    public void deleteQwner(String id) {

    }


    // APPLICATION METHODS
    //

    @Override
    public List<Application> getAllApps() {
        return null;
    }

    @Override
    public void writeApplication(Application appData) {

        Map<String, Object> con = connectToSQlite();

        if (con != null) {
            boolean bool = writeTable(appData, con);
        }

    }

    @Override
    public void deleteApplication(String id) {

    }


    // RENDERENGINE METHODS
    //

    @Override
    public List<Renderengine> getAllEngines() {
        return null;
    }

    @Override
    public void writeRenderengine(Renderengine engine) {

    }

    @Override
    public void deleteRenderengine(String id) {

    }

    // ASSET METHODS
    //


}
