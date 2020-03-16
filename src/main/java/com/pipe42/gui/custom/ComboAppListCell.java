package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Overrides the text output of the "Main project software" combobox in the Project/New Project UI
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboApp
 */
public class ComboAppListCell extends ListCell<ComboApp> {

    private static final Logger log = LoggerFactory.getLogger(ComboAppListCell.class);

    @Override
    public void updateItem(ComboApp comboApp, boolean empty) {
        log.trace("updateItem(): Wrapping combobox ID item with name");
        super.updateItem(comboApp, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboApp.getAppName());
        }
    }

}
