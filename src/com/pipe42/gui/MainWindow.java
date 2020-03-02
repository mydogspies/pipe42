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

/**
 * The main javafx window that opens on start
 */
public class MainWindow extends Application {

	private final Logger log = LoggerFactory.getLogger(MainWindow.class);

	/**
	 * The main stage for the application
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {

		// get the current Javafx css theme
		String appTitle = UserPreferences.userSettings.get("appTitle", "");
		String cssPath = UserPreferences.userSettings.get("cssPath", "");
		String cssTheme = UserPreferences.userSettings.get("cssDefaultTheme", "");

		try {
			Parent root = FXMLLoader.load(getClass().getResource("fxml/MainWindow.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(cssPath + cssTheme).toExternalForm());
			
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
