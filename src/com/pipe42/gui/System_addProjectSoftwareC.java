package com.pipe42.gui;

import com.pipe42.data.pojos.Application;
import com.pipe42.main.Main;
import com.pipe42.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the controller for the "Add Project Software" UI in System menu
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class System_addProjectSoftwareC {

    private static final Logger log = LoggerFactory.getLogger(System_addProjectSoftwareC.class);

    @FXML
    private TextField appName;

    @FXML
    private TextField appVersion;

    @FXML
    private TextField appExecParams;

    @FXML
    private TextField appPathToExecutable;

    @FXML
    private TextArea appNotes;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button newProjectSave;


    /* INIT */

    @FXML
    void initialize() {

        log.trace("initialize(): Has been called.");
    }


    /* CALL HANDLERS */

    /**
     * Action on pressing the save button
     * @param event from save button
     */
    @FXML
    void savedButtonPressed(ActionEvent event) {

        log.trace("savedButtonPressed(): ActionEvent called: " + event);

        String id = Util.getHash(appName.getText());

        Application app = new Application(id, appName.getText(), appVersion.getText(),
                appPathToExecutable.getText(), appExecParams.getText(), appNotes.getText());

        Main.factory.getIO().writeApplication(app);
    }

}
