package test;

import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.data.DatabaseSQLite;
import com.pipe42.data.pojos.Owner;
import com.pipe42.main.Initialize;
import com.pipe42.prefs.InitializeUserPreferences;
import com.pipe42.prefs.UserPreferences;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Here we are testing the SQL methods in DatabaseSQlite
 */
public class GetSQLDataTest {

    public static DatabaseAbstractFactory factory;

    public static void main(String[] args) throws SQLException {

        // start some general stuff
        //
        InitializeUserPreferences.initUserPrefs();
        // set log level
        Initialize.logReportLevel("trace"); // TODO this will have to be overridden in prefs
        // get stored user preferences
        UserPreferences.loadPrefsIntoProgram();
        // initialize stuff
        Initialize.setObjectMapper();
        factory = Initialize.databaseInitializer();


        // the the actual stuff we test
        //
        DatabaseSQLite db = new DatabaseSQLite();

        Map<String, Object> con = db.connectToSQlite();

        ResultSet rs = null;
        List<Owner> ownerList = new ArrayList<>();

        if (con != null) {
            rs = db.searchTableForRows("OWNER", "*", "", "OWNERNAME", con);
            int i = 0;
            while (rs.next()) {
                Owner owner = new Owner();
                owner.setOwnerId(rs.getString("OWNERID"));
                owner.setOwnerName(rs.getString("OWNERNAME"));
                owner.setOwnerCompany(rs.getString("OWNERCOMPANY"));
                owner.setOwnerDepartment(rs.getString("OWNERDEPARTMENT"));
                owner.setProjectManager(rs.getString("PROJECTMANAGER"));
                owner.setNotes(rs.getString("NOTES"));
                ownerList.add(owner);
            }

            db.closeSQliteConnection(con);
        }

    }

}
