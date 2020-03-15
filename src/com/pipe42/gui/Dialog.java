package com.pipe42.gui;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.util.Optional;

/**
 * Creates all types of dialog windows
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Dialog {

    private static final Logger log = LoggerFactory.getLogger(Dialog.class);

    /**
     * Shows a confirmation dialog window and returns boolean TRUE if pressed OK
     * @param headerText header text
     * @param contentText content text
     * @return boolean true if pressed OK, false otherwise
     */
    public static Boolean confirmationDialog(String headerText, String contentText) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("PIPE42 confirmation");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        log.debug("confirmationDialog(): Opened a separate window: " + alert);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            log.trace("confirmationDialog(): OK button pushed");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Opens a simple information window by input errors
     * @param headerText header text
     * @param contentText content text
     */
    public static void inputErrorDialog(String headerText, String contentText) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("PIPE42 input error");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        log.debug("inputErrorDialog(): Opened a separate window: " + alert);

        alert.showAndWait();
    }

    /**
     * Opens a separate DirectoryChooser dialog on top of the main stage.
     * @return the new path, empty string otherwise
     */
    public static String chooseDirectoryDialog() {

        DirectoryChooser dir = new DirectoryChooser();

        // Construct a new window
        Label label = new Label("pane");

        StackPane pane = new StackPane();
        pane.getChildren().add(label);

        Scene newScene = new Scene(pane, 400, 400);

        Stage newWindow = new Stage();
        newWindow.setTitle("PIPE42 Choose a directory");
        newWindow.setScene(newScene);
        newWindow.initModality(Modality.WINDOW_MODAL);

        log.debug("chooseDirectoryDialog(): Opened a new directory chooser: " + dir);

        File selectedDirectory = dir.showDialog(newWindow);

        if (selectedDirectory != null && selectedDirectory.isDirectory()) {
            log.trace("directoryDialog(): Directory selected: " + selectedDirectory.getAbsolutePath());
            return selectedDirectory.getAbsolutePath();
        } else {
            log.trace("chooseDirectoryDialog(): Exit without choice");
            return "";
        }

    }

    /**
     * Opens a separate FileChooser dialog on top of the main stage.
     * @return the new path, empty string otherwise
     */
    public static String chooseFileDialog() {

        FileChooser dir = new FileChooser();

        // Construct a new window
        Label label = new Label("pane");

        StackPane pane = new StackPane();
        pane.getChildren().add(label);

        Scene newScene = new Scene(pane, 400, 400);

        Stage newWindow = new Stage();
        newWindow.setTitle("PIPE42 Choose a directory");
        newWindow.setScene(newScene);
        newWindow.initModality(Modality.WINDOW_MODAL);

        log.debug("chooseFileDialog(): Opened a new directory chooser: " + dir);

        File selectedFile = dir.showOpenDialog(newWindow);

        if (selectedFile != null && selectedFile.isFile()) {
            log.trace("directoryDialog(): File selected: " + selectedFile.getAbsolutePath());
            return selectedFile.getAbsolutePath();
        } else {
            log.trace("chooseFileDialog(): Exit without choice");
            return "";
        }

    }

    /**
     * Opens a simple information window by input errors
     * @param headerText header text
     * @param contentText content text
     */
    public static void systemErrorDialog(String headerText, String contentText) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("PIPE42 system error");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        log.info("systemErrorDialog(): Opened a separate window: " + alert);

        alert.showAndWait();
    }

}
