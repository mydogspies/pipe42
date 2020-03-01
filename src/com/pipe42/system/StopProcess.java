package com.pipe42.system;

public class StopProcess {

    public static Boolean stopProcess(Process p) {

        if(p != null) {
            try {
                p.destroyForcibly();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
