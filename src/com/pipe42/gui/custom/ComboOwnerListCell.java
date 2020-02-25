package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;

/**
 * Overrides the text output of the "Project owner" combobox in the Project/New Project UI
 */
public class ComboOwnerListCell extends ListCell<ComboOwner> {

    @Override
    public void updateItem(ComboOwner comboOwner, boolean empty) {
        super.updateItem(comboOwner, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboOwner.getOwnerName());
        }
    }
}
