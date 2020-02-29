package com.pipe42.prefs;

import java.util.prefs.Preferences;

/**
 * Various methods for dealing with the user preferences stored on the computer by PIPE42.
 */
public class UserPreferences {

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

}
