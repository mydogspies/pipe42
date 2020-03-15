package com.pipe42.gui;

import com.pipe42.data.FileWorks;
import com.pipe42.data.PojoConstructor;
import com.pipe42.data.pojos.Project;
import com.pipe42.gui.custom.ComboApp;
import com.pipe42.gui.custom.ComboBoxFactory;
import com.pipe42.gui.custom.ComboEngine;
import com.pipe42.gui.custom.ComboOwner;
import com.pipe42.gui.custom.ComboProject;
import com.pipe42.gui.custom.ComboProjectListCell;
import com.pipe42.gui.validate.ValidateUserInput;
import com.pipe42.main.Main;
import com.pipe42.prefs.UserPreferences;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is the controller for the "Edit Project" UI in Projects menu
 *
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Project_editProjectC {

    private static final Logger log = LoggerFactory.getLogger(Project_editProjectC.class);

    @FXML
    private GridPane comboPane;

    @FXML
    private GridPane resultPane;

    @FXML
    private Label projectIDLabel;

    @FXML
    private TextArea projectNotes;

    @FXML
    private Button setPath;

    @FXML
    private Label invalidPathText;

    @FXML
    private CheckBox moveFoldersCheckBox;

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
    private String originalFolderPath; // this is the the root from which we will move if the option is chosen
    private Label folderPath; // this is always current value of the path variable
    private Tooltip folderPathTip;
    private Tooltip invalidPathTextTip;
    private Label created;
    private HashMap<String, String> creationTime; // so that we can pass it on once we read it dynamically
    private Label modified;
    AtomicBoolean projectNameValid = new AtomicBoolean(false);
    AtomicBoolean projectPrefixValid = new AtomicBoolean(false);
    AtomicBoolean setPathValid = new AtomicBoolean(false); // for passing on the folder path validation

    /**
     * Initializes all the dynamic content in the Edit Project UI
     */
    @FXML
    void initialize() {

        log.trace("initialize(): Started.");

        // PROJECT FIELDS
        //
        projectName = new TextField();
        resultPane.add(projectName, 1, 1);
        projectPrefix = new TextField();
        resultPane.add(projectPrefix, 1, 2);
        folderPath = new Label();
        folderPathTip = new Tooltip();
        folderPath.setTooltip(folderPathTip);
        resultPane.add(folderPath, 1, 7);
        invalidPathTextTip = new Tooltip();
        invalidPathText.setTooltip(invalidPathTextTip);
        created = new Label();
        resultPane.add(created, 1, 9);
        modified = new Label();
        resultPane.add(modified, 1, 10);

        invalidPathText.setVisible(false); // set this text invisible until we validated this below


        // PROJECT COMBOBOX
        //

        // dynamically create the projects combobox
        List<Project> projectList = Main.factory.getIO().getAllProjects();

        projectBox = new ComboBox<>();
        projectBox.getItems().add(new ComboProject("", "")); // first add an empty item

        // then the list of projects
        for (Project project : projectList) {
            projectBox.getItems().add(new ComboProject(project.getProjectName(), project.getProjectID()));
        }

        projectBox.setCellFactory(lv -> new ComboProjectListCell());
        projectBox.setButtonCell(new ComboProjectListCell());
        comboPane.add(projectBox, 1, 0);

        // add listener to the individual items in the combobox and dynamically load fields in the UI
        projectBox.valueProperty().addListener(new ChangeListener<ComboProject>() {

            @Override
            public void changed(ObservableValue<? extends ComboProject> observable, ComboProject oldValue, ComboProject newValue) {

                log.trace("initialize(): changed(): Project combobox (" + projectBox + ") has been accessed.");

                if (newValue != null) {

                    invalidPathText.setVisible(false); // reset this label between calls

                    String projectID = newValue.getProjectID();
                    Project project = Main.factory.getIO().getProjectByID(projectID);

                    projectIDLabel.setText(project.getProjectID());
                    projectName.setText(project.getProjectName());
                    projectPrefix.setText(project.getProjectPrefix());

                    // build the comboboxes
                    //
                    ComboBoxFactory cbf = new ComboBoxFactory();

                    // the Owner combobox
                    ownerBox = cbf.getOwnerComboBox();
                    String ownerID = project.getOwnerID();
                    int index = 0;
                    int count = 0;
                    List<ComboOwner> ownerList = ownerBox.getItems();
                    for (ComboOwner owner : ownerList) {
                        if (owner.getOwnerID().equals(ownerID)) {
                            index = count;
                        }
                        count++;
                    }
                    resultPane.add(ownerBox, 1, 3);
                    ownerBox.getSelectionModel().select(index);

                    // the Application combobox
                    app = cbf.getAppComboBox();
                    String appID = project.getApplicationID();
                    int index2 = 0;
                    int count2 = 0;
                    List<ComboApp> appList = app.getItems();
                    for (ComboApp appObject : appList) {
                        if (appObject.getAppID().equals(appID)) {
                            index2 = count2;
                        }
                        count2++;
                    }
                    resultPane.add(app, 1, 4);
                    app.getSelectionModel().select(index2);

                    // the Renderengine combobox
                    engine = cbf.getEngineComboBox();
                    String engineID = project.getEngineID();
                    int index3 = 0;
                    int count3 = 0;
                    List<ComboEngine> engineList = engine.getItems();
                    for (ComboEngine engineObject : engineList) {
                        if (engineObject.getEngineID().equals(engineID)) {
                            index3 = count3;
                        }
                        count3++;
                    }
                    resultPane.add(engine, 1, 5);
                    engine.getSelectionModel().select(index3);

                    // the folder template combobox
                    folderTemplate = cbf.getTemplateComboBox();
                    String folder = project.getProjectTemplate();
                    int index4 = 0;
                    int count4 = 0;
                    List<String> templateList = folderTemplate.getItems();
                    for (String templ : templateList) {
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
                    originalFolderPath = folderPath.getText();

                    creationTime = project.getCreationTime(); // also passed on in the event handler
                    created.setText(creationTime.get("date") + " " + creationTime.get("time"));
                    HashMap<String, String> modificationTime = project.getModifyTime();
                    modified.setText(modificationTime.get("date") + " " + modificationTime.get("time"));

                    projectNotes.setText(project.getNotes());


                    // validate the current project folder path
                    //
                    FileWorks fw = new FileWorks();
                    // TODO out all this in its own method in FileWorks
                    // first check for folder location on disc
                    if (!fw.fileExists(folderPath.getText())) {
                        invalidPathText.setVisible(true);
                        invalidPathTextTip.setText("No such folder root exists!");
                        log.warn("initilize()/changed(): No such folder exists: " + folderPath.getText());
                    } else if (!fw.fileExists(folderPath.getText() + "/.pipe42")) {
                        invalidPathText.setVisible(true);
                        invalidPathTextTip.setText("No .pipe42 file! Not a valid project directory!");
                        log.warn("initilize()/changed(): No .pipe42 in location: " + folderPath.getText());
                    } else {
                        setPathValid.set(true);
                    }


                    // add validation
                    //
                    ValidateUserInput vl = new ValidateUserInput();
                    vl.validateEditProjectName(projectNameValid, projectName, project.getProjectID());

                    ValidateUserInput vl2 = new ValidateUserInput();
                    vl2.validateEditProjectPrefix(projectPrefixValid, projectPrefix, project.getProjectID());


                    // dynamically create the DirectoryShow object for the folder path
                    //
                    setPath.setOnAction(event -> {

                        Boolean confirm = Dialog.confirmationDialog("Changing the folder path can potentially break your Project!",
                                "Are sure this is what you want to do?");

                        if (confirm) {
                            String path = Dialog.chooseDirectoryDialog();
                            folderPath.setText(path);
                        }

                    });

                }

            }
        });

        log.trace("initialize(): Finished initializing.");

    }

    /* EVENT HANDLERS */

    /**
     * This method validates that the user actually did a change in the folder path and
     * is simply not trying to copy within the same root.
     * @param event checkbox ticked event
     */
    @FXML
    private void moveFolderCheckBoxTicked(ActionEvent event) {

        // TODO implement this method and at the same time deal with path validation as per todo above

        log.trace("moveFolderCheckBoxTicked(): ActionEvent called: " + event);
    }


    /**
     * This method is fired when the Update project button is pressed.
     * It validates choices, updates the database with a new object and moves the project
     * folders if so chosen.
     * @param event button event
     */
    @FXML
    private void updateButtonPressed(ActionEvent event) {

        log.trace("updateButtonPressed(): ActionEvent called: " + event);

        // check validations
        //
        if (!projectNameValid.get()) {
            Dialog.inputErrorDialog("Project name is empty or already exists in the database!",
                    "Field can no be empty and must be duplicate of an existing project.");
        }

        if (!projectPrefixValid.get()) {
            String prefixLength = UserPreferences.userSettings.get("projectPrefixLength", "6");
            Dialog.inputErrorDialog("Prefix is either empty, already exists in the database or is longer than the amount of characters set in the system preferences!",
                    "Field can no be empty, must contain max " + prefixLength + " characters and must be duplicate of an existing project.");
        }

        // confirm dialog
        //
        Boolean confirm = Dialog.confirmationDialog("You are about to change data in your Project and if potentially move the entire folder structure!",
                "Are sure this is what you want to do?");

        // if then update the database
        //
        if (confirm) {

            PojoConstructor pc = new PojoConstructor();
            Project updatedProject = pc.updateProjectObject(projectIDLabel.getText(), projectName.getText(), projectPrefix.getText(),
                    ownerBox.getValue().getOwnerID(), engine.getValue().getEngineID(), app.getValue().getAppID(),
                    projectNotes.getText(), folderTemplate.getValue(), folderPath.getText(), creationTime);

            Main.factory.getIO().updateProject(updatedProject);
            log.trace("updateButtonPressed(): Project object sent off to updateProject: " + updatedProject);

            // and move folder structure if it is a valid location and the checkbox has been ticked
            if (moveFoldersCheckBox.isSelected() && setPathValid.get()) {

                FileWorks fw = new FileWorks();
                fw.moveDirectory(originalFolderPath, folderPath.getText());

                log.trace("updateButtonPressed(): Request to move directory sent off.");

            }

        }


    }

}
