package com.pipe42.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

public class System_addProjectOwnerC {

    @FXML
    private TextField ownerName;

    @FXML
    private TextField ownerCompany;

    @FXML
    private TextField ownerDepartment;

    @FXML
    private TextField projectManager;

    @FXML
    private TextArea ownerNotes;

    @FXML
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button newProjectSave;

    @FXML
    void savedButtonPressed(ActionEvent event) {

        // TODO add action on pressing the save button
        System.out.println(this.ownerName.getText());

    }

}
