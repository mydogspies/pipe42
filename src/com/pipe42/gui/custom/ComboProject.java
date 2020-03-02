package com.pipe42.gui.custom;

/**
 * Defines the wrapper class for the "Projects" combobox in Project/Delete Project and Edit Project UIs
 */
public class ComboProject {

    private final String projectName;
    private final String projectID;

    public ComboProject(String projectName, String projectID) {
        this.projectName = projectName;
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectID() {
        return projectID;
    }
}
