package com.pipe42.test;

import java.util.prefs.Preferences;

public class PreferencesAPITest {

    public static void setPrefs() {

        Preferences systemPreferences = Preferences.userRoot().node("/com/pipe42");

        systemPreferences.putInt("TESTINT", 100);
        systemPreferences.putBoolean("TESTBOOL", true);

        System.out.println(systemPreferences.getInt("TESTINT", 0));
        System.out.println(systemPreferences.getBoolean("TESTBOOL", false));

    }

    public static void getPrefs() {

        Preferences sysPrefs = Preferences.userRoot().node("/com/pipe42");

        System.out.println(sysPrefs.getInt("TESTINT", 0));
        System.out.println(sysPrefs.getBoolean("TESTBOOL", false));

    }

}
