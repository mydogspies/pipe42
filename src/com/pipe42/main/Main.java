package com.pipe42.main;

import com.pipe42.data.DatabaseAbstractFactory;
import com.pipe42.gui.MainWindow;
import com.pipe42.prefs.Reset;
import com.pipe42.prefs.UserPreferences;

/**
 * Default startup method for PIPE42
 * @author Peter Mankowski
 * @version 0.1.0-alpha
 *
 */
public class Main {

	public static DatabaseAbstractFactory factory;

	public static void main(String[] args) {
		
		// TODO - Main - Build a pre-loader

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
