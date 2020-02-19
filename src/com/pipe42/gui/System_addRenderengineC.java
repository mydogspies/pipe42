package com.pipe42.gui;

import com.pipe42.data.Renderengine;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

public class System_addRenderengineC {

    @FXML
    private TextField engineName;

    @FXML
    private TextField engineVersion;

    @FXML
    private TextField engineExecParams;

    @FXML
    private TextField enginePathToExecutable;

    @FXML
    private TextArea engineNotes;

    @FXML
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button engineSave;

    /* INIT */

    @FXML
    void initialize() {}

    /**
     * Action on pressing the save button
     * @param event
     */
    @FXML
    public void savedButtonPressed(ActionEvent event) {

        Renderengine engine = new Renderengine("1", engineName.getText(), enginePathToExecutable.getText(),
                engineExecParams.getText(), engineVersion.getText(), engineNotes.getText());

    }

}
