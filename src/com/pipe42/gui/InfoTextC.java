package com.pipe42.gui;

import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;
import javafx.scene.control.TextArea;

/**
 * Deals with the InfoText window
 * @author Mydogspies
 *
 */
public class InfoTextC {

	@FXML 
	private TextArea infoText_pane_textArea;
	
	@FXML
    void initialize() {

    }

	public void addText(String string) {
		
		infoText_pane_textArea.setText("string");
		
	}
	
}