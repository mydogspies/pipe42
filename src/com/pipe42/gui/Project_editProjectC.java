package com.pipe42.gui;

import com.pipe42.data.pojos.Project;
import com.pipe42.gui.custom.ComboApp;
import com.pipe42.gui.custom.ComboBoxFactory;
import com.pipe42.gui.custom.ComboEngine;
import com.pipe42.gui.custom.ComboOwner;
import com.pipe42.gui.custom.ComboProject;
import com.pipe42.gui.custom.ComboProjectListCell;
import com.pipe42.main.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import java.util.HashMap;
import java.util.List;

public class Project_editProjectC {

    @FXML
    private GridPane comboPane;

    @FXML
    private GridPane resultPane;

    @FXML
    private Label projectIDLabel;

    @FXML
    private TextArea projectNotes;

    @FXML
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;


    /* INIT */
    private ComboBox<ComboProject> projectBox;
    private TextField projectName;
    private TextField projectPrefix;
    private ComboBox<ComboOwner> ownerBox;
    private ComboBox<ComboEngine> engine;
    private ComboBox<ComboApp> app;
    private ComboBox<String> folderTemplate;
    private Label folderPath;
    private Tooltip folderPathTip;
    private Label created;
    private Label modified;

    @FXML
    void initialize() {

        // PROJECT FIELDS
        //
        projectName = new TextField();
        resultPane.add(projectName, 1, 1);
        projectPrefix = new TextField();
        resultPane.add(projectPrefix, 1, 2);
        // TODO the comboboxes for Owner, Engine and App
        folderPath = new Label();
        folderPathTip = new Tooltip();
        folderPath.setTooltip(folderPathTip);
        resultPane.add(folderPath, 1, 7);
        created = new Label();
        resultPane.add(created,1, 9);
        modified = new Label();
        resultPane.add(modified, 1, 10);


        // PROJECT COMBOBOX
        //

        // dynamically create the projects combobox
        List<Project> projectList = Main.factory.getIO().getAllProjects();

        projectBox = new ComboBox<>();
        projectBox.getItems().add(new ComboProject("", "")); // first add an empty item

        // then the list of projects
        for (Project project: projectList) {
            projectBox.getItems().add(new ComboProject(project.getProjectName(), project.getProjectID()));
        }

        projectBox.setCellFactory(lv -> new ComboProjectListCell());
        projectBox.setButtonCell(new ComboProjectListCell());
        comboPane.add(projectBox, 1 ,0);

        // add listener to the individual items in the combobox and dynamically load fields in the UI
        projectBox.valueProperty().addListener(new ChangeListener<ComboProject>() {
            @Override
            public void changed(ObservableValue<? extends ComboProject> observable, ComboProject oldValue, ComboProject newValue) {

                if (newValue != null) {

                    String projectID = newValue.getProjectID();
                    Project project = Main.factory.getIO().getProjectByID(projectID);

                    projectIDLabel.setText(project.getProjectID());
                    projectName.setText(project.getProjectName());
                    projectPrefix.setText(project.getProjectPrefix());

                    // build the comboboxes
                    //
                    ComboBoxFactory cbf = new ComboBoxFactory();

                    // the Owner combobox
                    ownerBox = cbf.getOwnerComboBox(ownerBox);
                    String ownerID = project.getOwnerID();
                    int index = 0;
                    int count = 0;
                    List<ComboOwner> ownerList = ownerBox.getItems();
                    for (ComboOwner owner: ownerList) {
                        if (owner.getOwnerID().equals(ownerID)) {
                            index = count;
                        }
                        count++;
                    }
                    resultPane.add(ownerBox, 1 ,3);
                    ownerBox.getSelectionModel().select(index);

                    // the Application combobox
                    app = cbf.getAppComboBox(app);
                    String appID = project.getApplicationID();
                    int index2 = 0;
                    int count2 = 0;
                    List<ComboApp> appList = app.getItems();
                    for (ComboApp appObject: appList) {
                        if (appObject.getAppID().equals(appID)) {
                            index2 = count2;
                        }
                        count2++;
                    }
                    resultPane.add(app, 1, 4);
                    app.getSelectionModel().select(index2);

                    // the Renderengine combobox
                    engine = cbf.getEngineComboBox(engine);
                    String engineID = project.getEngineID();
                    int index3 = 0;
                    int count3 = 0;
                    List<ComboEngine> engineList = engine.getItems();
                    for (ComboEngine engineObject: engineList) {
                        if (engineObject.getEngineID().equals(engineID)) {
                            index3 = count3;
                        }
                        count3++;
                    }
                    resultPane.add(engine, 1, 5);
                    engine.getSelectionModel().select(index3);

                    // the folder template combobox
                    folderTemplate = cbf.getTemplateComboBox(folderTemplate);
                    String folder = project.getProjectTemplate();
                    int index4 =0;
                    int count4 = 0;
                    List<String> templateList = folderTemplate.getItems();
                    for (String templ: templateList) {
                        if (templ.equals(folder)) {
                            index4 = count4;
                        }
                        count4++;
                    }
                    resultPane.add(folderTemplate, 1, 6);
                    folderTemplate.getSelectionModel().select(index4);


                    // then the remaining fields
                    //
                    folderPath.setText(project.getProjectPath());
                    folderPathTip.setText(project.getProjectPath());

                    HashMap<String, String> creationTime = project.getCreationTime();
                    created.setText(creationTime.get("date") + " " + creationTime.get("time"));
                    HashMap<String, String> modificationTime = project.getModifyTime();
                    modified.setText(modificationTime.get("date") + " " + modificationTime.get("time"));

                    projectNotes.setText(project.getNotes());


                }

            }
        });

    }


    /* EVENT HANDLERS */

    @FXML
    private void selectProject(ActionEvent event) {

    }

    @FXML
    private void updateButtonPressed(ActionEvent event) {

    }

}
