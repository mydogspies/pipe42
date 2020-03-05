package com.pipe42.gui;

import com.pipe42.data.pojos.Owner;
import com.pipe42.main.Main;
import com.pipe42.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the controller for the "Add Project Owner" UI in System menu
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class System_addProjectOwnerC {

    private static final Logger log = LoggerFactory.getLogger(System_addProjectOwnerC.class);

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

    @FXML
    void initialize() {

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

        String id = Util.getHash(ownerName.getText());

        Owner owner = new Owner(id, ownerName.getText(), ownerCompany.getText(), ownerDepartment.getText(),
                projectManager.getText(), ownerNotes.getText());

        Main.factory.getIO().writeOwner(owner);
    }

}
