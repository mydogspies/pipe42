package com.pipe42.gui.custom;

/**
 * Defines the wrapper class for the "Main project software" combobox in Project/New Project UI
 * @author Peter Mankowsi
 * @since 0.1.0
 * @see com.pipe42.gui.custom.ComboAppListCell
 */
public class ComboApp {

    private final String appName;
    private final String appID;

    public ComboApp(String appName, String appID) {
        this.appName = appName;
        this.appID = appID;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppID() {
        return appID;
    }
}
