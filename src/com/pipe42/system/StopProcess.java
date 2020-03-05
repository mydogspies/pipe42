package com.pipe42.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Stops a processes forcibly and cleans up if necessary
 */
public class StopProcess {

    private static final Logger log = LoggerFactory.getLogger(StopProcess.class);

    /**
     * Stops a process
     * @param p the process object
     * @return true if process stops, otherwise false
     */
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
