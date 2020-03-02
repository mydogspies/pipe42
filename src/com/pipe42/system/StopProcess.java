package com.pipe42.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopProcess {

    private static final Logger log = LoggerFactory.getLogger(StopProcess.class);

    public static Boolean stopProcess(Process p) {

        if(p != null) {
            try {
                p.destroyForcibly();
                log.debug("stopProcess(): Process {} has been terminated.", p);
                return true;
            } catch (Exception e) {
                log.warn("stopProcess(): Process {} could not be terminated.", p);
                e.printStackTrace();
            }
        }

        log.warn("com.pipe42.system.StopProcess.stopProcess: Process does not exist.");
        return false;
    }
}
