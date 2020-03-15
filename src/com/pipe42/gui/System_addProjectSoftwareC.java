package com.pipe42.gui;

import com.pipe42.data.PojoConstructor;
import com.pipe42.data.pojos.Application;
import com.pipe42.main.Main;
import com.pipe42.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

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
    private TextArea appNotes;

    @FXML
    private Button setPath;

    @FXML
    private Label filePath;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button newProjectSave;


    /* INIT */

    AtomicBoolean setPathValid = new AtomicBoolean(false);

    @FXML
    void initialize() {

        // dynamically create the DirectoryShow object
        //
        setPath.setOnAction(event -> {

            String path = Dialog.chooseFileDialog();
            filePath.setText(path);

            if (!filePath.getText().equals("") || !filePath.getText().equals("Set path!")) {
                setPathValid.set(true);
            } else {
                setPathValid.set(false);
            }
        });

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

        PojoConstructor pc = new PojoConstructor();

        Application app = pc.buildApplicationObject(appName.getText(), appVersion.getText(),
                setPath.getText(), appExecParams.getText(), appNotes.getText());

        Main.factory.getIO().writeApplication(app);

        log.trace("savedButtonPressed(): Project object sent off to writeProject: " + app);
    }

}
