package com.pipe42.prefs;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserPreferencesTest {

    @Test
    public void getPrefs() {

        boolean testBool = UserPreferences.getPrefs().getBoolean("TESTBOOL", false);
        int testInt = UserPreferences.getPrefs().getInt("TESTINT", 50);

        System.out.println("prefs/UserPreferences: TESTBOOL: " +  testBool);

        assertTrue(testBool);
        assertEquals(testInt, 100);



    }
}