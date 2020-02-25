package com.pipe42.gui;

import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;
import com.pipe42.gui.custom.ComboApp;
import com.pipe42.gui.custom.ComboAppListCell;
import com.pipe42.gui.custom.ComboEngine;
import com.pipe42.gui.custom.ComboEngineListCell;
import com.pipe42.gui.custom.ComboOwner;
import com.pipe42.gui.custom.ComboOwnerListCell;
import com.pipe42.util.Util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.HashMap;
import java.util.List;

public class Project_newProjectC {

	@FXML
	public GridPane comboPane;

	@FXML
	private TextField projectName;

	@FXML
	private TextField projectPrefix;

	@FXML
	private ComboBox<String> folderTemplate;

	@FXML
	private ComboBox<String> owner;

	@FXML
	private ComboBox<String> software;

	@FXML
	private ComboBox<String> engine;

	@FXML
	private TextArea projectNotes;


	@FXML
	private WebView htmlContent;

	@FXML
	private Button newProjectSave;


	/* INIT */

	private WebEngine webEngine;

	// TODO all the following vars must be defined below
	private String engineID;
	private String appID;
	private String ownerID;
	
	@FXML
    void initialize() {

		// grab initial content for the right hand part of the UI
		webEngine = htmlContent.getEngine();

		// populate the combo boxes
		//
		JsonDataIO io = new JsonDataIO();

		// dynamically create the "Project owner" combobox and wrap it in ComboOwner class
		List<Owner> ownerList = io.getAllOwners();
		ObservableList<ComboOwner> options = FXCollections.observableArrayList();
		ComboBox<ComboOwner> ownerBox = new ComboBox<>();

		for (Owner owner: ownerList) {
			ownerBox.getItems().add(new ComboOwner(owner.getOwnerName(), owner.getOwnerId()));
		}

		ownerBox.setCellFactory(lv -> new ComboOwnerListCell());
		ownerBox.setButtonCell(new ComboOwnerListCell());
		comboPane.add(ownerBox, 1 ,2);

		// dynamically create the "Main project software" combobox and wrap it in ComboApp class
		List<Application> appList = io.getAllApps();
		ObservableList<String> options2 = FXCollections.observableArrayList();
		ComboBox<ComboApp> appBox = new ComboBox<>();

		for (Application app: appList) {
			appBox.getItems().add(new ComboApp(app.getAppName(), app.getAppID()));
		}

		appBox.setCellFactory(lv -> new ComboAppListCell());
		appBox.setButtonCell(new ComboAppListCell());
		comboPane.add(appBox, 1, 3);

		// dynamically create the "Main render engine" combobox and wrap it in ComboEngine class
		List<Renderengine> engineList = io.getAllEngines();
		ObservableList<String> options3 = FXCollections.observableArrayList();
		ComboBox<ComboEngine> engineBox = new ComboBox<>();

		for (Renderengine eng: engineList) {
			engineBox.getItems().add(new ComboEngine(eng.getEngineName(), eng.getEngineID()));
		}

		engineBox.setCellFactory(lv -> new ComboEngineListCell());
		engineBox.setButtonCell(new ComboEngineListCell());
		comboPane.add(engineBox, 1, 4);

		// populate the "Project folder template" combobox
    }

	
	/* CALL HANDLERS */

	/**
	 * Action on pressing the save button
	 * @param event from save button
	 */
	@FXML
	public void savedButtonPressed(ActionEvent event) {

		String id = Util.getHash(projectName.getText());

		HashMap<String, String> creationTime = Util.getDateTime();
		HashMap<String, String> modifyTime = Util.getDateTime();

				// TODO a number of vars must be defined - see above!!!!
		Project project = new Project(id, projectName.getText(), projectPrefix.getText(), ownerID, engineID, appID,
				creationTime, modifyTime, projectNotes.getText());

		JsonDataIO io = new JsonDataIO();
		io.writeProject(project);

	}
	
}
