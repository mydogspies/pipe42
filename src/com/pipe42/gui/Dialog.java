package com.pipe42.gui;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

/**
 * Creates all types of dialog windows
 */
public class Dialog {

    /**
     * Shows a confirmation dialog window and returns boolean TRUE if pressed OK
     * @param headerText header text of type String
     * @param contentText content text of type String
     * @return boolean true if pressed OK, false otherwise
     */
    public static Boolean confirmationDialog(String headerText, String contentText) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("PIPE42 confirmation");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Opens a simple information window by input errors
     * @param headerText header text of type String
     * @param contentText content text of type String
     */
    public static void inputErrorDialog(String headerText, String contentText) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("PIPE42 input error");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    public static String directoryDialog() {

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

        File selectedDirectory = dir.showDialog(newWindow);

        if (selectedDirectory.isDirectory()) {
            return selectedDirectory.getAbsolutePath();
        }

        return null;
    }

}
