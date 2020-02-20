package com.pipe42.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
	
	@FXML
    void initialize() {

		webEngine = htmlContent.getEngine();

		owner.getItems().addAll("option1", "option2", "option3");

    }

	
	/* EVENT HANDLERS */
	
	@FXML
	public void savedButtonPressed(ActionEvent event) {

		System.out.println(this.projectName.getText());
		
	}
	
}
