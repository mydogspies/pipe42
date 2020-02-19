package com.pipe42.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import com.pipe42.console.ConsoleOut;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MainWindowC {
	
	/* Our two dynamic content areas */
	@FXML
	private Pane centerContent;


	/* INIT */

	@FXML
	void initialize() {
		
	}

	
	/* CALL HANDLERS */
	
	/**
	 * Handles all the calls from "Projects" top menu
	 * @param event call from menu item
	 */
	@FXML 
	private void projectMenu(ActionEvent event) {
		
		MenuItem m = (MenuItem) event.getSource();
		String menu_id = m.getId();
		
		switch (menu_id) {
		
		case "projects_newProject":
			addContentNewProject();
			break;
			
		case "projects_exit":
			Platform.exit(); // TODO - WindowMainC - add confirmation dialog
			break;
		
		}
	}
	
	/**
	 * Handles all the calls from "System" top menu
	 * @param event call from menu item
	 */
	@FXML 
	public void systemMenu(ActionEvent event) {
		
		MenuItem m = (MenuItem) event.getSource();
		String menu_id = m.getId();
		
		switch (menu_id) {
			case "system_addRenderengine": // TODO - WindowMainC - populate System menu
				addContentAddEngine();
				break;
			case "system_addProjectOwner":
				ConsoleOut.printCons("System-Add project owner"); // TODO remove console output
				break;
			case "system_addSoftwareApp":
				ConsoleOut.printCons("System-Add software application"); // TODO remove console output
				break;
		}
	}
	
	/**
	 * Handles all the calls from "Help" top menu
	 * @param event call from menu item
	 */
	@FXML 
	public void helpMenu(ActionEvent event) {
		
		MenuItem m = (MenuItem) event.getSource();
		String menu_id = m.getId();
		
		switch (menu_id) {
		case "help_about": // TODO - WindowMainC - populate Help menu
			ConsoleOut.printCons("Help-About"); // TODO remove console output
			break;
		
		}
	}
	
	
	/* METHODS */
	
	
	/**
	 * Adds the New Project UI
	 */
	private void addContentNewProject() {
		
		this.centerContent.getChildren().clear();
		
		try {
			// add the project menu content
			SplitPane p1 = FXMLLoader.load(getClass().getResource("Project.fxml"));
			centerContent.getChildren().add(p1);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load Project.fxml");
			e.printStackTrace();
		}
	}

	private void addContentAddEngine() {

		this.centerContent.getChildren().clear();

		try {
			// add the project menu content
			SplitPane p1 = FXMLLoader.load(getClass().getResource("system_addRenderengine.fxml"));
			centerContent.getChildren().add(p1);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load system_addRenderengine.fxml");
			e.printStackTrace();
		}

	}
	
}