package com.pipe42.prefs;

import com.pipe42.console.ConsoleOut;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Initializes the user preferences via the Preferences API
 * This specific class is only to be used by the installer to initiate a
 * fresh install of PIPE42 in its default mode
 */
public class InitializeUserPreferences {

    /**
     * Initializes all user preferences to its initial clean install state
     */
    public static void initUserPrefs() {

        Preferences userPreferences = UserPreferences.getPrefs();

        try {
            userPreferences.clear();
        } catch (BackingStoreException e) {
            ConsoleOut.printCons("Error: The system preferences of /com/pipe42 could not be cleared.");
            e.printStackTrace();
        }

        /* PROJECT SETTINGS */
        userPreferences.putInt("projectPrefixLength", 6);

        /* DATABASE */
        userPreferences.put("database", "json");
        userPreferences.put("databaseJsonRootPath", "src/data");
        userPreferences.put("databaseJsonDataPath", "src/data/data.json");
        userPreferences.put("databaseMongoPath", "C:/Program Files/MongoDB/Server/4.2/bin/mongod");
        userPreferences.put("databaseMongoDataPath", "M:/30_CODING/01_MIXENV/pipe42/src/data/mongodb");

        /* XML */
        userPreferences.put("xmlRootPath", "src/data");
        userPreferences.put("xmlTemplatePath", "src/data/templates");

        /* CSS */
        userPreferences.put("cssPath", "css/");
        userPreferences.put("cssDefaultTheme", "pipe42_default.css");

        /* MISC */
        userPreferences.putBoolean("testBool", true);
        userPreferences.put("appTitle", "PIPE42 version 0.1.0-alpha - NOT FOR PUBLIC RELEASE -");

    }

}
