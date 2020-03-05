package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Overrides the text output of the "Main render engine" combobox in the Project/New Project UI
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboEngine
 */
public class ComboEngineListCell extends ListCell<ComboEngine> {

    private static final Logger log = LoggerFactory.getLogger(ComboEngineListCell.class);

    @Override
    public void updateItem(ComboEngine comboEngine, boolean empty) {
        log.trace("updateItem(): Wrapping combobox ID item with name");
        super.updateItem(comboEngine, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboEngine.getEngineName());
        }
    }

}
