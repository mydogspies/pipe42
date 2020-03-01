package com.pipe42.test;

import com.pipe42.system.StopProcess;

public class KillProcess {

    public static Boolean stopProcess(Process p) {

        return StopProcess.stopProcess(p);

    }
}
