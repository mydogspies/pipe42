package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;

/**
 * Overrides the text output of the "Main render engine" combobox in the Project/New Project UI
 */
public class ComboEngineListCell extends ListCell<ComboEngine> {

    @Override
    public void updateItem(ComboEngine comboEngine, boolean empty) {
        super.updateItem(comboEngine, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboEngine.getEngineName());
        }
    }

}
