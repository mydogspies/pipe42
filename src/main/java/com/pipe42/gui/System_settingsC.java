package com.pipe42.gui;

import com.pipe42.prefs.UserPreferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.prefs.Preferences;

/**
 * This is the controller for the "Settings" UI in the Systems menu
 * @author Peter Mankowski
 * @since 0.3.0
 */
public class System_settingsC {

    @FXML
    private ComboBox<String> dbComboBox;

    @FXML
    private Button setJsonRootPath;

    @FXML
    private Button setJsonDataPath;

    @FXML
    private Button setSQliteRootPath;

    @FXML
    private Button setSQliteDbFile;

    @FXML
    private TextField prefixLength;

    @FXML
    private Button setXmlRootFolder;

    @FXML
    private Button setXmlTemplateFolder;

    @FXML
    private Button setCssRoot;

    @FXML
    private Button setCssDefaultTheme;

    @FXML
    private Pane Info_pane;

    @FXML
    private WebView htmlContent;

    @FXML
    private Button saveSettings;

    /* INIT */

    private WebEngine webEngine;

    @FXML
    void initialize() {

        Preferences prefs = UserPreferences.getPrefs();

        // Initiate dynamically the database combobox

        dbComboBox.getItems().removeAll(dbComboBox.getItems());
        dbComboBox.getItems().addAll("sqlite", "json");
        dbComboBox.getSelectionModel().select(prefs.get("database", ""));

        // grab initial content for the right hand part of the UI
        //
        webEngine = htmlContent.getEngine();
        URL url = getClass().getResource("html/system_settings.html");
        webEngine.load(String.valueOf(url));

    }


    @FXML
    void savedButtonPressed(ActionEvent event) {

    }

}
