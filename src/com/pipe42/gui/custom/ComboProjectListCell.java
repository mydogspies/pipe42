package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Overrides the text output of the "Project" combobox in the Project/New Project UI
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboProject
 */
public class ComboProjectListCell extends ListCell<ComboProject> {

    private static final Logger log = LoggerFactory.getLogger(ComboProjectListCell.class);

    @Override
    public void updateItem(ComboProject comboProject, boolean empty) {
        log.trace("updateItem(): Wrapping combobox ID item with name");
        super.updateItem(comboProject, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboProject.getProjectName());
        }
    }
}
