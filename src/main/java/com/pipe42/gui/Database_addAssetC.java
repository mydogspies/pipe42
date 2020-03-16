package com.pipe42.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * This is the controller for the "Database" UI in the Systems menu
 * @author Peter Mankowski
 * @since 0.3.0
 */
public class Database_addAssetC {

    private static final Logger log = LoggerFactory.getLogger(Database_addAssetC.class);

    @FXML
    private TextArea ownerNotes;

    @FXML
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button newAssetSave;

    /* INIT */

    private WebEngine webEngine;

    @FXML
    void initialize() {

        // grab initial content for the right hand part of the UI
        //
        webEngine = htmlContent.getEngine();
        URL url = getClass().getResource("html/database_addAsset.html");
        webEngine.load(String.valueOf(url));

        log.trace("initialize(): Has been called.");

    }

    /* EVENT HANDLERS */

    /**
     * Action on pressing the save button
     * @param event from save button
     */
    @FXML
    void savedButtonPressed(ActionEvent event) {

        log.trace("savedButtonPressed(): ActionEvent called: " + event);

        // TODO implement method

    }

}
