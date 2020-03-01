package com.pipe42.system;

import com.pipe42.main.Main;
import javafx.application.Platform;

public class ExitApplication {

    // TODO this class should contain proper shutdown and exit to system
    // x) save unsaved preferences
    // x) confirmation dialog for unsaved files
    // x) confirmation dialog to shut down any other 3rd party processes started from within PIPE42

    private static Process mongop = Main.mongoProcess;

    public static void exitAll() {

        // stop mongoDB client
        StopProcess.stopProcess(mongop);

        // exit to OS
        System.out.println("PIPE42 says bye!");
        Platform.exit();
    }

}
