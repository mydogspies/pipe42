package com.pipe42.gui;

import com.pipe42.data.PojoConstructor;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.Xml;
import com.pipe42.gui.custom.ComboApp;
import com.pipe42.gui.custom.ComboBoxFactory;
import com.pipe42.gui.custom.ComboEngine;
import com.pipe42.gui.custom.ComboOwner;
import com.pipe42.gui.validate.ValidateUserInput;
import com.pipe42.main.Main;
import com.pipe42.prefs.UserPreferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is the controller for the "New Project" UI in Projects menu
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Project_newProjectC {

	private static final Logger log = LoggerFactory.getLogger(Project_newProjectC.class);

	@FXML
	private GridPane comboPane;

	@FXML
	private Pane folderComboBoxPane;

	@FXML
	public CheckBox writeDirectoryCheck;

	@FXML
	private TextField projectName;

	@FXML
	private TextField projectPrefix;

	@FXML
	private TextArea projectNotes;

	@FXML
	private WebView htmlContent;

	@FXML
	private Button setPath;

	@FXML
	private Label directoryPath;


	/* INIT */

	private ComboBox<ComboOwner> ownerBox;
	private ComboBox<ComboApp> appBox;
	private ComboBox<ComboEngine> engineBox;
	private ComboBox<String> folderTemplate;
	private WebEngine webEngine;
	AtomicBoolean projectNameValid = new AtomicBoolean(false);
	AtomicBoolean projectPrefixValid = new AtomicBoolean(false);
	AtomicBoolean setPathValid = new AtomicBoolean(false);

	@FXML
    void initialize() {

		// add validation
		//
		ValidateUserInput vl = new ValidateUserInput();
		vl.validateNewProjectName(projectNameValid, projectName);

		ValidateUserInput vl2 = new ValidateUserInput();
		vl2.validateNewProjectPrefix(projectPrefixValid, projectPrefix);


		// grab initial content for the right hand part of the UI
		//
		webEngine = htmlContent.getEngine();
		URL urlHello = getClass().getResource("html/project_newProject_default.html");
		webEngine.load(String.valueOf(urlHello));


		// construct and populate the combo boxes
		//
		ComboBoxFactory cbf = new ComboBoxFactory();

		ownerBox = cbf.getOwnerComboBox(ownerBox);
		comboPane.add(ownerBox, 1 ,2);
		ownerBox.getSelectionModel().select(0);

		appBox = cbf.getAppComboBox(appBox);
		comboPane.add(appBox, 1, 3);
		appBox.getSelectionModel().select(0);

		engineBox = cbf.getEngineComboBox(engineBox);
		comboPane.add(engineBox, 1, 4);
		engineBox.getSelectionModel().select(0);

		folderTemplate = cbf.getTemplateComboBox(folderTemplate);
		folderComboBoxPane.getChildren().add(folderTemplate);
		folderTemplate.getSelectionModel().select(0);


		// dynamically create the DirectoryShow object
		//
		setPath.setOnAction(event -> {

			String path = Dialog.directoryDialog();
			directoryPath.setText(path);

			if (!directoryPath.getText().equals("") || !directoryPath.getText().equals("Set path!")) {
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
	public void savedButtonPressed(ActionEvent event) {

		log.trace("savedButtonPressed(): ActionEvent called: " + event);

		// check validations
		//
		if (!projectNameValid.get()) {
			Dialog.inputErrorDialog("Project name is either empty or already exists in the database!",
					"Field can no be empty and must be duplicate of an existing project.");
			return;
		}
		if (!projectPrefixValid.get()) {
			String prefixLength = UserPreferences.userSettings.get("projectPrefixLength", "6");
			Dialog.inputErrorDialog("Prefix is either empty, already exists in the database or is longer than the amount of characters set in the system preferences!",
					"Field can no be empty, must contain max "+ prefixLength + " characters and must be duplicate of an existing project.");
			return;
		}

		if (!setPathValid.get()) {
			Dialog.inputErrorDialog("The path to the root of the project folder directory must be set!",
					"Please, set the path to the root, eg. c:/somedir/root/project_folders");
			return;
		}


		// get the actual ID's from the combobox wrapper class
		String engineID = engineBox.getValue().getEngineID();
		String appID = appBox.getValue().getAppID();
		String ownerID = ownerBox.getValue().getOwnerID();

		// confirm dialog
		Boolean confirm = Dialog.confirmationDialog("You are about to add a new project to the database and, if you ticked the option, add a project folder tree to your hard drive.",
				"Are sure this is what you want to do?");

		if (confirm) {

			// build a POJO and send it off to writing
			PojoConstructor pc = new PojoConstructor();
			Project project = pc.buildProjectObject(projectName.getText(), projectPrefix.getText(), ownerID, engineID,
					appID, projectNotes.getText(), folderTemplate.getValue(), directoryPath.getText());

			Main.factory.getIO().writeProject(project);
			log.trace("savedButtonPressed(): Project object sent off to writeProject: " + project);

			// and then write the project directory if box ticked
			if (writeDirectoryCheck.isSelected()) {
				Xml.writeFolderTree(folderTemplate.getValue(), directoryPath.getText(), projectName.getText());
				log.trace("savedButtonPressed(): Write new folder structure request sent off to writeFolderTree: " + folderTemplate.getValue() + ": " + directoryPath.getText());
			}
		}

	}
	
}
