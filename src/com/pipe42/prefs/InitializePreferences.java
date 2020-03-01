package com.pipe42.prefs;

import com.pipe42.console.ConsoleOut;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Initializes the user preferences via the Preferences API
 * This specific class is only to be used by the installer to initiate a
 * fresh install of PIPE42 in its default mode
 */
public class InitializePreferences {

    /**
     * Initializes all user preferences to its initial clean install state
     */
    public static void initPrefs() {

        Preferences systemPreferences = UserPreferences.getPrefs();

        try {
            systemPreferences.clear();
        } catch (BackingStoreException e) {
            ConsoleOut.printCons("Error: The system preferences of /com/pipe42 could not be cleared.");
            e.printStackTrace();
        }

        /* DATABASE */
        systemPreferences.put("database", "json");
        systemPreferences.put("databaseRootPath", "src/data");
        systemPreferences.put("databaseDataPath", "src/data/data.json");

        /* MISC */
        systemPreferences.putBoolean("testBool", true);

    }

}
