package com.pipe42.test;


import com.pipe42.main.Main;
import com.pipe42.prefs.InitializeUserPreferences;
import com.pipe42.prefs.UserPreferences;

public class TestGround {

    public static void main(String[] args) {

        UserPreferences.loadPrefs();
        System.out.println(UserPreferences.userSettings.get("databaseMongoPath", ""));

        Process p = Main.mongoProcess;

        System.out.println(p);

        System.out.println(KillProcess.stopProcess(p));

    }

}
