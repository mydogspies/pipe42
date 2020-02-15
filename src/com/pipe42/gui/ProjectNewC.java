package com.pipe42.gui;

import com.pipe42.console.ConsoleOut;

import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;

public class ProjectNewC {
	
	@FXML
	private TitledPane titledPane_project;
	
	@FXML
    void initialize() {
		
    }

	/* EVENT HANDLERS */
	
	@FXML public void titledPaneExpand(MouseEvent event) {
		
		TitledPane t = (TitledPane) event.getSource();
		
		System.out.println(titledPane_project.getScene().getUserData());
		
		switch(t.getId()) {
		case "titledPane_project":
			break;
		case "titledPane_owner":
			break;
		case "titledPane_engine":
			break;
		case "titledPane_app":
			break;
		default:
			ConsoleOut.printCons("Error in the call method of ProjectNewC.titledPaneExpand");
		}
		
		
		
	}
	
}
