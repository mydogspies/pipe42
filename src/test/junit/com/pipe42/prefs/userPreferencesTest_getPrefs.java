package com.pipe42.prefs;

import org.junit.Test;

import java.util.prefs.Preferences;

import static org.junit.Assert.*;

public class userPreferencesTest_getPrefs {

    @Test
    public void getPrefs() {

        assertTrue(UserPreferences.getPrefs().getBoolean("testBool", false));

    }
}