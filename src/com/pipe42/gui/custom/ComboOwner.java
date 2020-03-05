package com.pipe42.gui.custom;

/**
 * Defines the wrapper class for the "Project owner" combobox in Project/New Project UI
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboOwnerListCell
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
