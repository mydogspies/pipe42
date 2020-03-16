package com.pipe42.gui;

import com.pipe42.data.PojoConstructor;
import com.pipe42.data.pojos.Owner;
import com.pipe42.main.Main;
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
 * This is the controller for the "Add Project Owner" UI in System menu
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Database_addProjectOwnerC {

    private static final Logger log = LoggerFactory.getLogger(Database_addProjectOwnerC.class);

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
    private WebView htmlContent;

    @FXML
    private Button newProjectSave;


    /* INIT */

    private WebEngine webEngine;

    @FXML
    void initialize() {

        // grab initial content for the right hand part of the UI
        //
        webEngine = htmlContent.getEngine();
        URL url = getClass().getResource("html/database_addProjectOwner.html");
        webEngine.load(String.valueOf(url));

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

        Owner owner = pc.buildOwnerObject(ownerName.getText(), ownerCompany.getText(), ownerDepartment.getText(),
                projectManager.getText(), ownerNotes.getText());

        Main.factory.getIO().writeOwner(owner);
        log.debug("savedButtonPressed(): Project object sent off to writeProject: " + owner);
    }

}
