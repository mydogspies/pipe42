package com.pipe42.system;

import com.pipe42.prefs.UserPreferences;

import java.io.IOException;

public class ProcessMongoDB {

    public static Process startMongoDB() {

        ProcessBuilder pb = new ProcessBuilder();
        String installPath = UserPreferences.userSettings.get("databaseMongoPath", "");
        String installDataPath = UserPreferences.userSettings.get("databaseMongoDataPath", "");
        pb.command(installPath, "--dbpath", installDataPath);
        Process p;

        try {
            p = pb.start();
            return p;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
