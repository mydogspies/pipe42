package com.pipe42.system;

import com.pipe42.prefs.UserPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ProcessMongoDB {

    private static final Logger log = LoggerFactory.getLogger(ProcessMongoDB.class);

    public static Process startMongoDB() {

        ProcessBuilder pb = new ProcessBuilder();
        String installPath = UserPreferences.userSettings.get("databaseMongoPath", "");
        String installDataPath = UserPreferences.userSettings.get("databaseMongoDataPath", "");
        pb.command(installPath, "--dbpath", installDataPath);
        Process p;

        try {
            p = pb.start();
            log.info("startMongoDB(): MongoDB process has been started: {}", p);
            return p;
        } catch (IOException e) {
            log.error("startMongoDB(): MongoDB could not be started: {}", e.getCause().getLocalizedMessage());
            e.printStackTrace();
        }

        return null;
    }

}
