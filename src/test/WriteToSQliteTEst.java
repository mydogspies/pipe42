package test;

import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.data.DatabaseSQLite;
import com.pipe42.data.SQliteUtilities;
import com.pipe42.data.pojos.Application;
import com.pipe42.main.Initialize;
import com.pipe42.prefs.UserPreferences;

public class WriteToSQliteTEst {

    public static DatabaseAbstractFactory factory;

    public static void main(String[] args) {


        // set log level
        Initialize.logReportLevel("trace");

        // get stored user preferences
        UserPreferences.loadPrefsIntoProgram();

        // initialize stuff
        Initialize.setObjectMapper();
        factory = Initialize.databaseInitializer();

        DatabaseSQLite sql = new DatabaseSQLite();
        SQliteUtilities util = new SQliteUtilities();

        Application app = new Application("jhgrew", "Maya", "2022", "c:/", "-nomoreexceptions", "Loads of stuff to test");

        // sql.writeApplication(app);

        // sql.deleteApplication("qwert");
        // sql.deleteRenderengine("d6d7755");

        //System.out.println(sql.getDatabaseInfo());

        // System.out.println(sql.getProjectByID("ndgwrt"));
        sql.getAllOwners();

        // System.out.println(util.findPrimaryKeyName("owner"));

        // System.out.println(PojoParser.parsePojoToMap(app));

    }
}
