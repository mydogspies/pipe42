package com.pipe42.test;


import com.pipe42.prefs.UserPreferences;

public class TestGround {

    public static void main(String[] args) {

        // PreferencesAPITest.setPrefs();

        System.out.println(UserPreferences.getPrefs().getBoolean("TESTBOOL", false));

    }

}
