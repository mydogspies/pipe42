package test;

import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.data.SQliteUtilities;
import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Asset;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;
import com.pipe42.main.Initialize;
import com.pipe42.prefs.UserPreferences;

public class WritePojoToSQL {

    public static DatabaseAbstractFactory factory;

    public static void main(String[] args) {

        // the init stuff
        //
        // set log level
        Initialize.logReportLevel("debug");

        // get stored user preferences
        UserPreferences.loadPrefs();

        // initialize stuff
        Initialize.setObjectMapper();
        factory = Initialize.databaseInitializer();


        // DB STUFF
        //
        Project pr = new Project();
        Application app = new Application();
        Owner ow = new Owner();
        Renderengine rend = new Renderengine();
        Asset ass = new Asset();

        SQliteUtilities.createTableFromPojo(pr);
        SQliteUtilities.createTableFromPojo(app);
        SQliteUtilities.createTableFromPojo(ow);
        SQliteUtilities.createTableFromPojo(rend);
        SQliteUtilities.createTableFromPojo(ass);
    }

}
