package com.pipe42.gui;

import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;
import com.pipe42.util.Util;
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

    @FXML
    void initialize() {}


    /* CALL HANDLERS */

    /**
     * Action on pressing the save button
     * @param event from save button
     */
    @FXML
    void savedButtonPressed(ActionEvent event) {

        String id = Util.getHash(appName.getText());

        Application app = new Application(id, appName.getText(), appVersion.getText(),
                appPathToExecutable.getText(), appExecParams.getText(), appNotes.getText());

        JsonDataIO io = new JsonDataIO();
        io.writeApplication(app);
    }

}
