package com.pipe42.gui;

import com.pipe42.gui.custom.ComboBoxFactory;
import com.pipe42.gui.custom.ComboProject;
import com.pipe42.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the controller for the "delete Project" UI in Projects menu
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Project_deleteProjectC {

    private static final Logger log = LoggerFactory.getLogger(Project_deleteProjectC.class);

    /**
     * The GridPane in which objects are being dynamically created
     */
    @FXML
    private GridPane comboPane;

    @FXML
    private TextArea ownerNotes;

    @FXML
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;

    /* INIT */
    private ComboBox<ComboProject> projectBox;

    /**
     * Initializes in this case all the elements that need to be created dynamically
     */
    @FXML
    public void initialize() {

        // TODO add content of current project selected showing on web view

        // dynamically create the projects combobox
        ComboBoxFactory cbf = new ComboBoxFactory();
        projectBox = cbf.getProjectComboBox(projectBox);
        comboPane.add(projectBox, 1 ,0);
        projectBox.getSelectionModel().select(0);

        log.trace("initialize(): Has been called.");
    }


    /* EVEN HANDLERS */

    /**
     * Handles the event in case of pressing the Delete Button in order to delete a project in the database
     * @param event the call event
     */
    @FXML
    void deleteButtonPressed(ActionEvent event) {

        log.trace("deleteButtonPressed(): ActionEvent called: " + event);

        // TODO add project folder deletion and log file write including notes
        // TODO check for .pipe42 as validation when deletion box checked! Both existence and valid project name.

        Main.factory.getIO().deleteProject(projectBox.getValue().getProjectID());

        log.info("deleteButtonPressed(): Project " + projectBox.getValue().getProjectID() + " has been sent off for deletion");

    }

}
