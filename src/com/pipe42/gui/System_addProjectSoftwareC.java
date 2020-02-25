package com.pipe42.gui;

import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * Controller for the System/Add Project Software UI
 * System_addProjectSoftware.fxml
 */
public class System_addProjectSoftwareC {

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

    void initialize() {}


    /* CALL HANDLERS */

    @FXML
    void savedButtonPressed(ActionEvent event) {

        Application app = new Application("", appName.getText(), appVersion.getText(),
                appPathToExecutable.getText(), appExecParams.getText(), appNotes.getText());

        JsonDataIO io = new JsonDataIO();

        // send of to json handler
        io.writeApplication(app);

    }

}
