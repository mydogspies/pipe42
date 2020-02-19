package com.pipe42.gui;

import com.pipe42.console.ConsoleOut;
import com.pipe42.util.Util;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ProjectC {

	@FXML
	private TextField projectName;

	@FXML
	private TextField projectPrefix;

	@FXML
	private CheckBox preloadFiles;

	@FXML
	private TextArea projectNotes;

	@FXML
	private TitledPane titledPane_owner;

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
	private TextField engineName;

	@FXML
	private TextField engineVersion;

	@FXML
	private TextField engineExecParams;

	@FXML
	private TextField enginePathToExecutable;

	@FXML
	private TextArea engineNotes;

	@FXML
	private TitledPane titledPane_app;

	@FXML
	private TextField appName;

	@FXML
	private TextField appVersion;

	@FXML
	private TextField appExecParams;

	@FXML
	private TextField appPathToExecutable;

	@FXML
	private TextArea appNotes;

	@FXML
	private TitledPane titledPane_project;
	
	@FXML
	private Button newProjectSave;
	
	@FXML
	private WebView htmlContent;


	/* INIT */

	private WebEngine engine;
	
	@FXML
    void initialize() {
		engine = htmlContent.getEngine();
    }

	
	/* EVENT HANDLERS */
	
	/**
	 * Events from accordion menu in "New Project"
	 * @param event incoming event from mouse click on top nav menu
	 */
	@FXML 
	public void expandNewProject(MouseEvent event) {
		
		// get some utils
		Util ut = new Util();
		
		TitledPane t = (TitledPane) event.getSource();
		String url;
		
		switch(t.getId()) {
		case "titledPane_project":
			url = ut.getLocalURL("/com/pipe42/gui/html/project_project.html");
			engine.load(url);
			break;
		case "titledPane_owner":
			url = ut.getLocalURL("/com/pipe42/gui/html/project_owner.html");
			engine.load(url);
			break;
		case "titledPane_engine":
			url = ut.getLocalURL("/com/pipe42/gui/html/project_engine.html");
			engine.load(url);
			break;
		case "titledPane_app":
			url = ut.getLocalURL("/com/pipe42/gui/html/project_app.html");
			engine.load(url);
			break;
		default:
			ConsoleOut.printCons("Error in the call method of ProjectC.titledPaneExpand");
		}
		
	}
	
	@FXML
	public void savedButtonPressed(ActionEvent event) {

		System.out.println(this.projectName.getText());
		
	}
	
}
