package com.pipe42.prefs;

import com.pipe42.console.ConsoleOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Initializes the user preferences via the Preferences API
 * This specific class is only to be used by the installer to initiate a
 * fresh install of PIPE42 in its default mode
 */
public class InitializeUserPreferences {

    private static final Logger log = LoggerFactory.getLogger(InitializeUserPreferences.class);

    /**
     * Initializes all user preferences to its initial clean install state
     */
    public static void initUserPrefs() {

        Preferences userPreferences = UserPreferences.getPrefs();

        try {
            userPreferences.clear();
            log.debug("initUserPrefs(): User Preferences have been cleared.");
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
        userPreferences.put("databaseSQLPath", "");
        userPreferences.put("databaseSQLDataPath", "");

        /* XML */
        userPreferences.put("xmlRootPath", "src/data");
        userPreferences.put("xmlTemplatePath", "src/data/templates");

        /* CSS */
        userPreferences.put("cssPath", "css/");
        userPreferences.put("cssDefaultTheme", "pipe42_default.css");

        /* MISC */
        userPreferences.putBoolean("testBool", true);
        userPreferences.put("appTitle", "PIPE42 version 0.1.0-alpha - NOT FOR PUBLIC RELEASE -");

        log.info("initUserPrefs(): User preferences have been cleared and replaced by default values.");
    }

}
