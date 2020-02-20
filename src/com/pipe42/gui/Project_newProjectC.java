package com.pipe42.gui;

import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.List;

public class Project_newProjectC {

	@FXML
	private TextField projectName;

	@FXML
	private TextField projectPrefix;

	@FXML
	private CheckBox preloadFiles;

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
	private String creationTime;
	private String modifyTime;
	
	@FXML
    void initialize() {

		// grab initial content for the right hand part of the UI
		webEngine = htmlContent.getEngine();

		// populate the combo boxes
		//
		JsonDataIO io = new JsonDataIO();

		List<Owner> ownerList = io.getAllOwners();
		ObservableList<String> options = FXCollections.observableArrayList();
		for (Owner owner: ownerList) { options.add(owner.getOwnerName()); }
		owner.getItems().addAll(options);
		ownerID = "";

		List<Application> appList = io.getAllApps();
		ObservableList<String> options2 = FXCollections.observableArrayList();
		for (Application app: appList) { options2.add(app.getAppName()); }
		software.getItems().addAll(options2);
		appID = "";

		List<Renderengine> engineList = io.getAllEngines();
		ObservableList<String> options3 = FXCollections.observableArrayList();
		for (Renderengine eng: engineList) { options3.add(eng.getEngineName()); }
		engine.getItems().addAll(options3);
		ownerID = "";

		// TODO define methods for this in com.pipe42.util in the Util class
		creationTime = "";
		modifyTime = "";
    }

	
	/* EVENT HANDLERS */
	
	@FXML
	public void savedButtonPressed(ActionEvent event) {

		// TODO a number of vars must be defined - see above!!!!
		Project project = new Project("", projectName.getText(), projectPrefix.getText(), ownerID, engineID, appID,
				creationTime, modifyTime, projectNotes.getText());
		
	}
	
}
