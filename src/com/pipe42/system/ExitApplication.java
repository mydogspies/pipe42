package com.pipe42.system;

import ch.qos.logback.classic.LoggerContext;
import com.pipe42.console.ConsoleOut;
import com.pipe42.main.Main;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitApplication {

    private static final Logger log = LoggerFactory.getLogger(ExitApplication.class);

    // TODO this class should contain proper shutdown and exit to system
    // x) save unsaved preferences
    // x) confirmation dialog for unsaved files
    // x) confirmation dialog to shut down any other 3rd party processes started from within PIPE42

    private static Process mongop = Main.mongoProcess;

    public static void exitAll() {

        log.info("exitAll(): Exit with a clean shutdown! Bye!");

        // stop mongoDB client
        StopProcess.stopProcess(mongop);


        // release resources used by logback for a clean exit
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.stop();

        // exit to OS
        Platform.exit();
    }

}
