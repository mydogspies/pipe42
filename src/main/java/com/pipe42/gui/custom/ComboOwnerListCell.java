package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Overrides the text output of the "Project owner" combobox in the Project/New Project UI
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboOwner
 */
public class ComboOwnerListCell extends ListCell<ComboOwner> {

    private static final Logger log = LoggerFactory.getLogger(ComboOwnerListCell.class);

    @Override
    public void updateItem(ComboOwner comboOwner, boolean empty) {
        log.trace("updateItem(): Wrapping combobox ID item with name");
        super.updateItem(comboOwner, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboOwner.getOwnerName());
        }
    }
}
