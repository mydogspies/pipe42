package com.pipe42.gui;

import com.pipe42.prefs.UserPreferences;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.prefs.Preferences;

/**
 * This is the controller for the "Settings" UI in the Systems menu
 * @author Peter Mankowski
 * @since 0.3.0
 */
public class System_settingsC {

    private static final Logger log = LoggerFactory.getLogger(System_settingsC.class);

    @FXML
    private ComboBox<String> dbComboBox;

    @FXML
    private ComboBox<String> logComboBox;

    @FXML
    private ComboBox<String> logPathComboBox;

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

        // Initiate dynamically the comboboxes
        //
        dbComboBox.getItems().removeAll(dbComboBox.getItems());
        dbComboBox.getItems().addAll("sqlite", "json");
        dbComboBox.getSelectionModel().select(prefs.get("database", ""));

        logComboBox.getItems().removeAll(logComboBox.getItems());
        logComboBox.getItems().addAll("error", "warn", "info", "debug", "trace");
        logComboBox.getSelectionModel().select(prefs.get("logLevel", ""));

        logPathComboBox.getItems().removeAll(logPathComboBox.getItems());
        logPathComboBox.getItems().addAll("file only", "console only", "file and console");
        logPathComboBox.getSelectionModel().select(1);

        // grab initial content for the right hand part of the UI
        //
        webEngine = htmlContent.getEngine();
        URL url = getClass().getResource("html/system_settings.html");
        webEngine.load(String.valueOf(url));

        webEngine.getLoadWorker().stateProperty().addListener(
                (ObservableValue<? extends Worker.State> observable,
                 Worker.State oldValue,
                 Worker.State newValue) -> {
                    if( newValue != Worker.State.SUCCEEDED ) {
                        return;
                    }
                        sendSettingsToHTML(webEngine);
                } );

    }


    @FXML
    void savedButtonPressed(ActionEvent event) {

    }

    /**
     * Sends off the setting values to the javascript function that places them in the Html page.
     * @param webengine takes the current WebEngine object that represents the page we are sending to
     */
    private void sendSettingsToHTML(WebEngine webengine) {

        Preferences prefs = UserPreferences.getPrefs();
        JavaScript js = new JavaScript();

        js.setInnerHtmlValues(webengine, "appVersion", prefs.get("appVersion", ""));
        js.setInnerHtmlValues(webengine, "jsonRoot", prefs.get("databaseJsonRootPath", ""));
        js.setInnerHtmlValues(webengine, "jsonData", prefs.get("databaseJsonDataPath", ""));
        js.setInnerHtmlValues(webengine, "sqliteRoot", prefs.get("databaseSQLiteRootPath", ""));
        js.setInnerHtmlValues(webengine, "sqliteData", prefs.get("databaseSQLiteDataPath", ""));
        js.setInnerHtmlValues(webengine, "xmlRoot", prefs.get("xmlRootPath", ""));
        js.setInnerHtmlValues(webengine, "xmlTemplates", prefs.get("xmlTemplatePath", ""));
        js.setInnerHtmlValues(webengine, "cssRoot", prefs.get("cssPath", ""));
        js.setInnerHtmlValues(webengine, "cssDefault", prefs.get("cssDefaultTheme", ""));


    }


}
