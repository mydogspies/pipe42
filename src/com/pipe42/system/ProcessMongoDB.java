package com.pipe42.system;

import java.io.IOException;

public class ProcessMongoDB {

    public static Process startMongoDB() {

        ProcessBuilder pb = new ProcessBuilder();
        pb.command("C:\\Program Files\\MongoDB\\Server\\4.2\\bin\\mongod", "--dbpath", "M:\\30_CODING\\01_MIXENV\\pipe42\\src\\data\\mongodb"); // TODO should be from SYSTEM VARS
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
