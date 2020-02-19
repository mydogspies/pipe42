package com.pipe42.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

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

    @FXML
    void savedButtonPressed(ActionEvent event) {

        // TODO add action on pressing the save button
        System.out.println(this.appName.getText());

    }

}
