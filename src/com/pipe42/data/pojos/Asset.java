package com.pipe42.data.pojos;

import java.util.HashMap;

/**
 * The Asset POJO
 */
public final class Asset {

    private String assetID;
    private String name;
    private String projectID;
    private String appID;
    private HashMap<String, AssetTypes> pathToWorkfiles;
    private String versionFormat;
    private String separatorChar;
    private HashMap<String, AssetTypeOutput> pathToOutput;
    private String assetOwnerID;
    private String notes;


    /* CONSTRUCTORS */

    public Asset() {}

    public Asset(String assetID, String name, String projectID, String appID, HashMap<String,
            AssetTypes> pathToWorkfiles, String versionFormat, String separatorChar, HashMap<String,
            AssetTypeOutput> pathToOutput, String assetOwnerID, String notes) {

        this.assetID = assetID;
        this.name = name;
        this.projectID = projectID;
        this.appID = appID;
        this.pathToWorkfiles = pathToWorkfiles;
        this.versionFormat = versionFormat;
        this.separatorChar = separatorChar;
        this.pathToOutput = pathToOutput;
        this.assetOwnerID = assetOwnerID;
        this.notes = notes;
    }


    /* GETTERS AND SETTERS */

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public HashMap<String, AssetTypes> getPathToWorkfiles() {
        return pathToWorkfiles;
    }

    public void setPathToWorkfiles(HashMap<String, AssetTypes> pathToWorkfiles) {
        this.pathToWorkfiles = pathToWorkfiles;
    }

    public String getVersionFormat() {
        return versionFormat;
    }

    public void setVersionFormat(String versionFormat) {
        this.versionFormat = versionFormat;
    }

    public String getSeparatorChar() {
        return separatorChar;
    }

    public void setSeparatorChar(String separatorChar) {
        this.separatorChar = separatorChar;
    }

    public HashMap<String, AssetTypeOutput> getPathToOutput() {
        return pathToOutput;
    }

    public void setPathToOutput(HashMap<String, AssetTypeOutput> pathToOutput) {
        this.pathToOutput = pathToOutput;
    }

    public String getAssetOwnerID() {
        return assetOwnerID;
    }

    public void setAssetOwnerID(String assetOwnerID) {
        this.assetOwnerID = assetOwnerID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
