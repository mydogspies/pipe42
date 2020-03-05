package com.pipe42.main;

import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.gui.MainWindow;
import com.pipe42.prefs.UserPreferences;

/**
 * Default startup class Main
 * Initializes a number of things and in the end calls the {@MainWindow} class to open the main application window
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.MainWindow
 */
public class Main {

	public static DatabaseAbstractFactory factory;

	public static void main(String[] args) {
		
		// TODO - Main - Build a pre-loader

		// set log level
		Initialize.logReportLevel("debug"); // TODO this will have to be overridden in prefs

		// get stored user preferences
		UserPreferences.loadPrefs();

		// initialize stuff
		Initialize.setObjectMapper();
		factory = Initialize.databaseInitializer();

		// reset all
		// Reset reset = new Reset();
		// reset.resetAll();
		
		// open main GUI window
		MainWindow.main(args);

	}

}
