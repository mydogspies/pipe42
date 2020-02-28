package com.pipe42.system;

public class StopProcess {

    public static Boolean stopProcess(Process p) {

        try {
            p.destroyForcibly();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
