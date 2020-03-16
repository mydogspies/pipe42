package com.pipe42.prefs;

import com.pipe42.console.ConsoleOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Initializes the user preferences via the Preferences API.
 * This specific class is only to be used by the installer to initiate a
 * fresh install of PIPE42 in its default mode.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.prefs.UserPreferences
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
            log.warn("initUserPrefs(): User preferences could not be cleared due to some error.");
        }

        /* PROJECT SETTINGS */
        userPreferences.putInt("projectPrefixLength", 6);

        /* DATABASE */
        userPreferences.put("database", "sqlite");
        userPreferences.put("databaseJsonRootPath", "src/main/java/data");
        userPreferences.put("databaseJsonDataPath", "src/main/java/data/data.json");
        userPreferences.put("databaseSQLiteRootPath", "src/main/java/data/sqlite");
        userPreferences.put("databaseSQLiteDataPath", "src/main/java/data/sqlite/data/pipe42.db");

        /* XML */
        userPreferences.put("xmlRootPath", "src/main/java/data");
        userPreferences.put("xmlTemplatePath", "src/main/java/data/templates");

        /* CSS */
        userPreferences.put("cssPath", "src/main/java/com/pipe42/gui/css");
        userPreferences.put("cssDefaultTheme", "default.css");

        /* SYSTEM */
        userPreferences.putBoolean("testBool", true);
        userPreferences.put("appVersion", "0.2.0-alpha");
        userPreferences.put("logLevel", "info");

        /* GUI LOCATIONS */

        log.info("initUserPrefs(): User preferences have been cleared and replaced by default values.");
    }

}
