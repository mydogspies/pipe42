package com.pipe42.gui;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class MainWindow extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/MainWindow.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("css/pipe42_default.css").toExternalForm()); // TODO - WindowsMain - dynamically load style sheet
			
			primaryStage.setTitle("PIPE42 verison 0.1 pre-alpha prototype - NOT FOR PUBLIC RELEASE -"); // TODO - WindowMain - Dynamically add title
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
