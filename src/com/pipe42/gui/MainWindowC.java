package com.pipe42.gui;

import com.pipe42.system.ExitApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import com.pipe42.console.ConsoleOut;

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
				addNewProject();
				break;

			case "projects_editProject":
				addEditProject();
				break;

			case "projects_deleteProject":
				addDeleteProject();
				break;

			case "projects_exit":
				// TODO - WindowMainC - add confirmation dialog
				ExitApplication.exitAll();
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
				addAddEngine();
				break;

			case "system_addProjectOwner":
				addAddProjectOwner();
				break;

			case "system_addSoftwareApp":
				addAddSoftware();
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

	// PROJECT MENU
	//

	/**
	 * Adds the New Project UI under "Projects" menu
	 */
	private void addNewProject() {
		
		this.centerContent.getChildren().clear();
		
		try {
			// add the project menu content
			SplitPane p = FXMLLoader.load(getClass().getResource("fxml/Project_newProject.fxml"));
			centerContent.getChildren().add(p);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load Project_newProject.fxml");
			e.printStackTrace();
		}
	}

	/**
	 * Adds the New Project UI under "Projects" menu
	 */
	private void addEditProject() {

		this.centerContent.getChildren().clear();

		try {
			// add the project menu content
			SplitPane p = FXMLLoader.load(getClass().getResource("fxml/Project_editProject.fxml"));
			centerContent.getChildren().add(p);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load Project_editProject.fxml");
			e.printStackTrace();
		}
	}

	private void addSearchProject() {

		// TODO add the addContentSearchProject method
	}

	private void addDeleteProject() {

		this.centerContent.getChildren().clear();

		try {
			// add the project menu content
			SplitPane p = FXMLLoader.load(getClass().getResource("fxml/Project_deleteProject.fxml"));
			centerContent.getChildren().add(p);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load Project_deleteProject.fxml");
			e.printStackTrace();
		}
	}


	// SYSTEM MENU
	//

	/**
	 * Adds the Add Renderengine UI under "Systems" menu
	 */
	private void addAddEngine() {

		this.centerContent.getChildren().clear();

		try {
			// add the project menu content
			SplitPane p = FXMLLoader.load(getClass().getResource("fxml/System_addRenderengine.fxml"));
			centerContent.getChildren().add(p);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load System_addRenderengine.fxml");
			e.printStackTrace();
		}

	}

	/**
	 * Adds the Add Project Software UI under "System" menu
	 */
	private void addAddSoftware() {

		this.centerContent.getChildren().clear();

		try {
			// add the project menu content
			SplitPane p = FXMLLoader.load(getClass().getResource("fxml/System_addProjectSoftware.fxml"));
			centerContent.getChildren().add(p);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load System_addProjectSoftware.fxml");
			e.printStackTrace();
		}

	}

	/**
	 * Adds the Add Project Owner UI under "System" menu
	 */
	private void addAddProjectOwner() {

		this.centerContent.getChildren().clear();

		try {
			// add the project menu content
			SplitPane p = FXMLLoader.load(getClass().getResource("fxml/System_addProjectOwner.fxml"));
			centerContent.getChildren().add(p);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load System_addProjectOwner.fxml");
			e.printStackTrace();
		}

	}
	
}