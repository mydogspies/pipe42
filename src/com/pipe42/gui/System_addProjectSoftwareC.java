package com.pipe42.gui;

import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button newProjectSave;

    /* INIT */

    void initialize() {}


    /* CALL HANDLERS */

    @FXML
    void savedButtonPressed(ActionEvent event) {

        // TODO fix the hardwired "id" value!!!!
        Application app = new Application("2", appName.getText(), appVersion.getText(),
                appPathToExecutable.getText(), appExecParams.getText(), appNotes.getText());

        JsonDataIO io = new JsonDataIO();

        // send of to json handler
        io.writeApplication(app);

    }

}
