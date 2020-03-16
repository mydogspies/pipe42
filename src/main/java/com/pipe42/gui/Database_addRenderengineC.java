package com.pipe42.gui;

import com.pipe42.data.pojos.Renderengine;
import com.pipe42.main.Main;
import com.pipe42.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * This is the controller for the "Add Renderengine" UI in System menu
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Database_addRenderengineC {

    private static final Logger log = LoggerFactory.getLogger(Database_addRenderengineC.class);

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

    private WebEngine webEngine;

    @FXML
    void initialize() {

        // grab initial content for the right hand part of the UI
        //
        webEngine = htmlContent.getEngine();
        URL url = getClass().getResource("html/database_addRenderengine.html");
        webEngine.load(String.valueOf(url));

        log.trace("initialize(): Has been called.");
    }


    /* CALL HANDLERS */

    /**
     * Action on pressing the save button
     * @param event from save button
     */
    @FXML
    public void savedButtonPressed(ActionEvent event) {

        log.trace("savedButtonPressed(): ActionEvent called: " + event);

        String id = Util.getHash(engineName.getText());

        Renderengine engine = new Renderengine(id, engineName.getText(), enginePathToExecutable.getText(),
                engineExecParams.getText(), engineVersion.getText(), engineNotes.getText());

        Main.factory.getIO().writeRenderengine(engine);
    }

}
