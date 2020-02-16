package com.pipe42.gui;

import java.net.URL;

import com.pipe42.console.ConsoleOut;

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
	
	@FXML 
	public void titledPaneExpand(MouseEvent event) {
		
		TitledPane t = (TitledPane) event.getSource();
		String url;
		
		switch(t.getId()) {
		case "titledPane_project":
			url = getLocalURL("/com/pipe42/gui/html/project_project.html");
			engine.load(url);
			break;
		case "titledPane_owner":
			url = getLocalURL("/com/pipe42/gui/html/project_owner.html");
			engine.load(url);
			break;
		case "titledPane_engine":
			url = getLocalURL("/com/pipe42/gui/html/project_engine.html");
			engine.load(url);
			break;
		case "titledPane_app":
			url = getLocalURL("/com/pipe42/gui/html/project_app.html");
			engine.load(url);
			break;
		default:
			ConsoleOut.printCons("Error in the call method of ProjectC.titledPaneExpand");
		}
		
	}
	
	/**
	 * Translate local path into proper URL
	 * @param path
	 * @return formatted URL from local path
	 */
	private String getLocalURL(String path) {
		
		URL url = this.getClass().getResource(path);
		return url.toString();
		
	}
	
}
