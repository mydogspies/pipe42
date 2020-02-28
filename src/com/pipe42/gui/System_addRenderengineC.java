package com.pipe42.gui;

import com.pipe42.data.pojos.Renderengine;
import com.pipe42.main.Main;
import com.pipe42.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * Controller for the System/Add Rendenengine UI
 * System_addRenderengine.fxml
 */
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
    private WebView htmlContent;

    @FXML
    private Button engineSave;


    /* INIT */

    @FXML
    void initialize() {}


    /* CALL HANDLERS */

    /**
     * Action on pressing the save button
     * @param event from save button
     */
    @FXML
    public void savedButtonPressed(ActionEvent event) {

        String id = Util.getHash(engineName.getText());

        Renderengine engine = new Renderengine(id, engineName.getText(), enginePathToExecutable.getText(),
                engineExecParams.getText(), engineVersion.getText(), engineNotes.getText());

        Main.factory.getIO().writeRenderengine(engine);
    }

}
