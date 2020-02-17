package com.pipe42.gui;

import com.pipe42.console.ConsoleOut;
import com.pipe42.utils.Utils;

import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ProjectC {
	
	@FXML
	private TitledPane titledPane_project;
	
	@FXML
	private WebView htmlContent;
	
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
		Utils ut = new Utils();
		
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
	
}
