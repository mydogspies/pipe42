package com.pipe42.prefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.prefs.Preferences;

/**
 * Stores and manipulates the user preferences using the Preference API
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.prefs.InitializeUserPreferences
 */
public class UserPreferences {

    private static final Logger log = LoggerFactory.getLogger(UserPreferences.class);
    public static Preferences userSettings;

    /**
     * Reads and returns an object with all the user preferences
     * This is stored in "HKEY_CURRENT_USER\Software\JavaSoft\UserPrefs" for Windows
     * in "${user.home}/.java/.userPrefs" on Linux.
     * No admin rights should be required for this process.
     * @return a References API object
     */
    public static Preferences getPrefs() {

        Preferences prefs = Preferences.userRoot().node("/com/pipe42");

        if (prefs != null) {
            log.debug("getPrefs(): Successfully read system preferences.");
            return prefs;
        } else {
            log.error("getPrefs(): Could not read system preferences! (Is this first time this program runs?)");
            return null;
        }
    }

    /**
     * Simply initializes the global static variable userSettings with the proper data
     */
    public static void loadPrefsIntoProgram() {

        userSettings = getPrefs();
        log.info("loadPrefs(): loaded user preferences into userSettings from: {}", userSettings);

    }

}
