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

        return Preferences.userRoot().node("/com/pipe42");

    }

    /**
     * Simply initializes the global static variable userSettings with the proper data
     * @return true if userSettings are not null, otherwise false
     */
    public static Boolean loadPrefs() {

        userSettings = getPrefs();
        log.info("loadPrefs(): loaded user preferences into userSettings from: {}", userSettings);

        if(userSettings != null) {
            return true;
        }

        return false;

    }

}
