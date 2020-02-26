package com.pipe42.gui;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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

    public static void fieldsMissingDialog(String headerText, String contentText) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("PIPE42 input error");
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

}
