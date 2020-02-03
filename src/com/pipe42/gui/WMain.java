package com.pipe42.gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class WMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("WMain.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("pipe42_default.css").toExternalForm()); // TODO - WindowsMain - dynamically load style sheet
			primaryStage.setTitle("PIPE42 verison 0.1 pre-alpha - NOT FOR PUBLIC RELEASE -"); // TODO - WindowMain - Dynamically add title
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
