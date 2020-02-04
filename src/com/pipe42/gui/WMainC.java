package com.pipe42.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

import java.io.IOException;

import com.pipe42.console.ConsoleOut;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class WMainC {
	
	
	/* Our two dynamic content areas */
	@FXML
	private Pane splitPane_center_leftPane;
	@FXML
	private Pane splitPane_center_rightPane;
	
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
			addContentProjectNew();
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
	
	private void addContentProjectNew() {
		
		this.splitPane_center_leftPane.getChildren().clear();
		this.splitPane_center_rightPane.getChildren().clear();
		
		try {
			Pane p1 = FXMLLoader.load(getClass().getResource("WProjectNew.fxml"));
			splitPane_center_leftPane.getChildren().add(p1);
		} catch (IOException e) {
			ConsoleOut.printCons("Not able to load WProjectNew.fxml");
			e.printStackTrace();
		}
	}
	
}