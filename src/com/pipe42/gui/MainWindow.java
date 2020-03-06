package com.pipe42.gui;
	
import com.pipe42.prefs.UserPreferences;
import com.pipe42.system.ExitApplication;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The main javafx window that opens on start
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class MainWindow extends Application {

	private final Logger log = LoggerFactory.getLogger(MainWindow.class);

	/**
	 * The main stage for the application
	 * @param primaryStage the main stage in this application
	 */
	@Override
	public void start(Stage primaryStage) {

		// get the current Javafx css theme
		String appTitle = UserPreferences.userSettings.get("appTitle", "");
		String cssPath = UserPreferences.userSettings.get("cssPath", "");
		String cssTheme = UserPreferences.userSettings.get("cssDefaultTheme", "");

		String home = System.getProperty("user.dir");
		Path cssURI = Paths.get(home,cssPath, cssTheme);
		System.out.println("cssURI = " + cssURI);
		System.out.println(Files.exists(cssURI));

		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/MainWindow.fxml"));
			log.trace("start(): Seems we loaded MainWindow.fxml successfully.");
			
			Scene scene = new Scene(root);
			log.trace("start(): New scene instantiated: " + scene);
			scene.getStylesheets().add(getClass().getResource(cssURI.toString()).toExternalForm());
			log.trace("start(): Seems we loaded the default css file successfully.");
			
			primaryStage.setTitle(appTitle);
			primaryStage.setScene(scene);
			primaryStage.show();
			log.debug("start(): Main window has been opened ({})", appTitle);
		} catch(Exception e) {
			log.error("start(): Main window could not be opened: {}", e.getCause().getLocalizedMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Overrides the stop() method to see to that we have a clean exit even if someone
	 * clicks on the corner exit icon on top of the window.
	 */
	@Override
	public void stop() {

		ExitApplication.exitAll();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
