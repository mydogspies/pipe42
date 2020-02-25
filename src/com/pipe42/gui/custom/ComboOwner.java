package com.pipe42.gui.custom;

/**
 * Defines the wrapper class for the "Project owner" combobox in Project/New Project UI
 */
public class ComboOwner {

    private final String ownerName;
    private final String ownerID;

    public ComboOwner(String ownerName, String ownerID) {
        this.ownerName = ownerName;
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerID() {
        return ownerID;
    }
}
