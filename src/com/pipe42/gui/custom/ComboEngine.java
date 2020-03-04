package com.pipe42.gui.custom;

/**
 * Defines the wrapper class for the "Main render engine" combobox in Project/New Project UI
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboEngineListCell
 */
public class ComboEngine {

    private final String engineName;
    private final String engineID;

    public ComboEngine(String engineName, String engineID) {
        this.engineName = engineName;
        this.engineID = engineID;
    }

    public String getEngineID() {
        return engineID;
    }

    public String getEngineName() {
        return engineName;
    }
}
