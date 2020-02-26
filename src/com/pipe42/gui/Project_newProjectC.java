package com.pipe42.gui;

import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;
import com.pipe42.data.Owner;
import com.pipe42.data.PojoConstructor;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;
import com.pipe42.data.Xml;
import com.pipe42.gui.custom.ComboApp;
import com.pipe42.gui.custom.ComboAppListCell;
import com.pipe42.gui.custom.ComboEngine;
import com.pipe42.gui.custom.ComboEngineListCell;
import com.pipe42.gui.custom.ComboOwner;
import com.pipe42.gui.custom.ComboOwnerListCell;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Project_newProjectC {

	@FXML
	public GridPane comboPane;

	@FXML
	public CheckBox writeDirectoryCheck;

	@FXML
	private TextField projectName;

	@FXML
	private TextField projectPrefix;

	@FXML
	private ComboBox<String> folderTemplate;

	@FXML
	private TextArea projectNotes;

	@FXML
	private WebView htmlContent;

	@FXML
	private Button newProjectSave;


	/* INIT */

	private ComboBox<ComboOwner> ownerBox;
	private ComboBox<ComboApp> appBox;
	private ComboBox<ComboEngine> engineBox;
	private WebEngine webEngine;
	AtomicBoolean projectNameValid = new AtomicBoolean(false);
	AtomicBoolean projectPrefixValid = new AtomicBoolean(false);

	@FXML
    void initialize() {

		// add validation to the fields
		//
		ValidateUserInput vl = new ValidateUserInput();
		vl.validateNewProjectFields(projectNameValid, projectName);

		ValidateUserInput vl2 = new ValidateUserInput();
		vl2.validateNewProjectFields(projectPrefixValid, projectPrefix);

		// grab initial content for the right hand part of the UI
		webEngine = htmlContent.getEngine();

		// populate the combo boxes
		//
		JsonDataIO io = new JsonDataIO();

		// dynamically create the "Project owner" combobox and wrap it in ComboOwner class
		List<Owner> ownerList = io.getAllOwners();
		ownerBox = new ComboBox<>();

		for (Owner owner: ownerList) {
			ownerBox.getItems().add(new ComboOwner(owner.getOwnerName(), owner.getOwnerId()));
		}

		ownerBox.setCellFactory(lv -> new ComboOwnerListCell());
		ownerBox.setButtonCell(new ComboOwnerListCell());
		comboPane.add(ownerBox, 1 ,2);
		ownerBox.getSelectionModel().select(0);

		// dynamically create the "Main project software" combobox and wrap it in ComboApp class
		List<Application> appList = io.getAllApps();
		appBox = new ComboBox<>();

		for (Application app: appList) {
			appBox.getItems().add(new ComboApp(app.getAppName(), app.getAppID()));
		}

		appBox.setCellFactory(lv -> new ComboAppListCell());
		appBox.setButtonCell(new ComboAppListCell());
		comboPane.add(appBox, 1, 3);
		appBox.getSelectionModel().select(0);

		// dynamically create the "Main render engine" combobox and wrap it in ComboEngine class
		List<Renderengine> engineList = io.getAllEngines();
		engineBox = new ComboBox<>();

		for (Renderengine eng: engineList) {
			engineBox.getItems().add(new ComboEngine(eng.getEngineName(), eng.getEngineID()));
		}

		engineBox.setCellFactory(lv -> new ComboEngineListCell());
		engineBox.setButtonCell(new ComboEngineListCell());
		comboPane.add(engineBox, 1, 4);
		engineBox.getSelectionModel().select(0);

		// populate the "Project folder template" combobox
		List<String> templateList = Xml.getXmlTemplateNames();
		ObservableList<String> options = FXCollections.observableArrayList();
		for (String name: templateList) { options.add(name); }
		folderTemplate.getItems().addAll(options);
		folderTemplate.getSelectionModel().select(0);

    }

	
	/* CALL HANDLERS */

	/**
	 * Action on pressing the save button
	 * @param event from save button
	 */
	@FXML
	public void savedButtonPressed(ActionEvent event) {

		if (!projectNameValid.get()) {
			Dialog.fieldsMissingDialog("Project name is empty!", "Please fill in the all the required fields.");
			return;
		}
		if (!projectPrefixValid.get()) {
			Dialog.fieldsMissingDialog("Project prefix is empty!", "Please fill in the all the required fields.");
			return;
		}

		// TODO the input validation methods

		// get the actual ID's from the combobox wrapper class
		String engineID = engineBox.getValue().getEngineID();
		String appID = appBox.getValue().getAppID();
		String ownerID = ownerBox.getValue().getOwnerID();

		// confirm dialog
		Boolean confirm = Dialog.confirmationDialog("You are about to add a new project to the database and, if you ticked the option, add a project folder tree to your hard drive.",
				"Are sure this is what you want to do?");

		if (confirm) {

			// build a POJI and send it off to writing
			PojoConstructor pc = new PojoConstructor();
			Project project = pc.buildProjectObject(projectName.getText(), projectPrefix.getText(), ownerID, engineID,
					appID, projectNotes.getText());

			JsonDataIO io = new JsonDataIO();
			io.writeProject(project);

			// and then write the project directory if box ticked
			if (writeDirectoryCheck.isSelected()) {
				Xml.writeFolderTree(folderTemplate.getValue());
			}
		}

	}
	
}
