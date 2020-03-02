package com.pipe42.gui;

import com.pipe42.data.DatabaseJson;
import com.pipe42.data.pojos.Project;
import com.pipe42.gui.custom.ComboProject;
import com.pipe42.gui.custom.ComboProjectListCell;
import com.pipe42.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import java.util.List;

public class Project_deleteProjectC {

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

    @FXML
    public void initialize() {

        // TODO add content of current project selected showing on web view

        // dynamically create the projects combobox
        List<Project> projectList = Main.factory.getIO().getAllProjects();

        projectBox = new ComboBox<>();

        for (Project project: projectList) {
            projectBox.getItems().add(new ComboProject(project.getProjectName(), project.getProjectID()));
        }

        projectBox.setCellFactory(lv -> new ComboProjectListCell());
        projectBox.setButtonCell(new ComboProjectListCell());
        comboPane.add(projectBox, 1 ,0);
        projectBox.getSelectionModel().select(0);

    }


    /* EVEN HANDLERS */

    @FXML
    void deleteButtonPressed(ActionEvent event) {

        // TODO add project folder deletion and log file write including notes
        // TODO check for .pipe42 as validation when deletion box checked! Both existence and valid project name.

        Main.factory.getIO().deleteProject(projectBox.getValue().getProjectID());
        System.out.println("Project " + projectBox.getValue().getProjectName() + " has been deleted.");

    }

}
