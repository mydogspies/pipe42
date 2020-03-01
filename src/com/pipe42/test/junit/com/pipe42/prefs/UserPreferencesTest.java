package com.pipe42.prefs;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserPreferencesTest {

    @Test
    public void getPrefs() {

        boolean testBool = UserPreferences.getPrefs().getBoolean("testBool", false);

        System.out.println("prefs/UserPreferences: testBool: " +  testBool);

        assertTrue(testBool);

    }
}