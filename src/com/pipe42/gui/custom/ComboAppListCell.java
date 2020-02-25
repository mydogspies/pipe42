package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;

/**
 * Overrides the text output of the "Main project software" combobox in the Project/New Project UI
 */
public class ComboAppListCell extends ListCell<ComboApp> {

    @Override
    public void updateItem(ComboApp comboApp, boolean empty) {
        super.updateItem(comboApp, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboApp.getAppName());
        }
    }

}
