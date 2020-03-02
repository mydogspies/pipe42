package com.pipe42.gui.custom;

import javafx.scene.control.ListCell;

public class ComboProjectListCell extends ListCell<ComboProject> {

    @Override
    public void updateItem(ComboProject comboProject, boolean empty) {
        super.updateItem(comboProject, empty);
        if (empty) {
            setText(null);
        } else {
            setText(comboProject.getProjectName());
        }
    }
}
