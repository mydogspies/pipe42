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
	
	@FXML
	void initialize() {
		
	}

	
	/* CALL HANDLERS */
	
	/**
	 * Handles all the calls from "Projects" in vbox_top_menuBar
	 * @param event call from menu item
	 */
	@FXML 
	private void projectMenu(ActionEvent event) {
		
		MenuItem m = (MenuItem) event.getSource();
		String menu_id = m.getId();
		
		switch (menu_id) {
		
		case "vbox_top_menuBar_file_newProject":
			addContentProject();
			break;
			
		case "vbox_top_menuBar_file_exit":
			Platform.exit(); // TODO - WindowMainC - add confirmation dialog
			break;
		
		}
	}
	
	/**
	 * Handles all the calls from "System" in vbox_top_menuBar
	 * @param event call from menu item
	 */
	@FXML 
	public void systemMenu(ActionEvent event) {
		
		MenuItem m = (MenuItem) event.getSource();
		String menu_id = m.getId();
		
		switch (menu_id) {
		case "": // TODO - WindowMainC - populate System menu
			break;
		
		}
	}
	
	/**
	 * Handles all the calls from "Help" in vbox_top_menuBar
	 * @param event call from menu item
	 */
	@FXML 
	public void helpMenu(ActionEvent event) {
		
		MenuItem m = (MenuItem) event.getSource();
		String menu_id = m.getId();
		
		switch (menu_id) {
		case "": // TODO - WindowMainC - populate Help menu
			break;
		
		}
	}
	
	
	/* METHODS */
	
	
	/**
	 * Adds the project menu accordion to the UI
	 */
	private void addContentProject() {
		
		this.centerContent.getChildren().clear();
		
		try {
			// add the project menu content
			SplitPane p1 = FXMLLoader.load(getClass().getResource("Project.fxml"));
			centerContent.getChildren().add(p1);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load fxml files; Project");
			e.printStackTrace();
		}
	}
	
}