package com.pipe42.gui;

import com.pipe42.data.JsonDataIO;
import com.pipe42.data.Owner;
import com.pipe42.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * Controller for the System/Add Project Owner UI
 * System_addProjectOwner.fxml
 */
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
    private WebView htmlContent;

    @FXML
    private Button newProjectSave;


    /* INIT */

    @FXML
    void initialize() {}


    /* CALL HANDLERS */

    /**
     * Action on pressing the save button
     * @param event from save button
     */
    @FXML
    void savedButtonPressed(ActionEvent event) {

        String id = Util.getHash(ownerName.getText());

        Owner project = new Owner(id, ownerName.getText(), ownerCompany.getText(), ownerDepartment.getText(),
                projectManager.getText(), ownerNotes.getText());

        JsonDataIO io = new JsonDataIO();
        io.writeOwner(project);
    }

}
