package com.pipe42.main;


import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.gui.MainWindow;
import com.pipe42.prefs.UserPreferences;
import com.pipe42.system.ProcessMongoDB;


/**
 * Default startup method for PIPE42
 * @author Peter Mankowski
 * @version 0.1.0-alpha
 *
 */
public class Main {

	public static DatabaseAbstractFactory factory;
	public static Process mongoProcess = null;

	public static void main(String[] args) {
		
		// TODO - Main - Build a pre-loader

		// get stored user preferences
		UserPreferences.loadPrefs();

		// start MongoDB if it's the default database
		if (UserPreferences.userSettings.get("database", "").equals("mongo")) {
			mongoProcess = ProcessMongoDB.startMongoDB();
		}

		// initialize stuff
		Initialize.setObjectMapper();
		factory = Initialize.databaseInitializer();
		
		// open main GUI window
		MainWindow.main(args);

	}



}
