package com.pipe42.data.pojos;

import java.util.HashMap;

/**
 * This is the Asset model object used by our DAO.
 * @author Peter Mankowski
 * @since 0.2.0
 *
 */
public final class Asset {

    private String assetID;
    private String name;
    private String projectID;
    private String appID;
    private HashMap<String, String> pathToWorkfiles;
    private HashMap<String, AssetTypes> pathToAssets;
    private String versionFormat;
    private String separatorChar;
    private HashMap<String, AssetTypeOutput> pathToOutput;
    private String assetOwnerID;
    private String notes;


    /* CONSTRUCTORS */

    /**
     * Empty constructor is only used for external libraries that rely on a default definition
     */
    public Asset() {}

    /**
     * The Asset model object constructor for the DAO.
     */
    public Asset(String assetID, String name, String projectID, String appID, HashMap<String,
            String> pathToWorkfiles, HashMap<String, AssetTypes> pathToAssets, String versionFormat, String separatorChar, HashMap<String,
            AssetTypeOutput> pathToOutput, String assetOwnerID, String notes) {

        this.assetID = assetID;
        this.name = name;
        this.projectID = projectID;
        this.appID = appID;
        this.pathToWorkfiles = pathToWorkfiles;
        this.pathToAssets = pathToAssets;
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

    /**
     * The unique ID of the asset.
     * @param assetID Derived from hashing utility com.pipe42.util.Util
     * @see com.pipe42.util.Util
     */
    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    /**
     * The name of the asset
     * @param name UTF-8
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getProjectID() {
        return projectID;
    }

    /**
     * The unique ID of the project this asset belongs to. Derived from com.pipe42.data.pojos.Project
     * @param projectID derived from com.pipe42.data.pojos.Project
     * @see com.pipe42.data.pojos.Project
     */
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getAppID() {
        return appID;
    }

    /**
     * The unique ID of the particular software application this asset belongs to. Derived from com.pipe42.data.pojos.Application
     * @param appID derived from com.pipe42.data.pojos.Application
     * @see com.pipe42.data.pojos.Application
     */
    public void setAppID(String appID) {
        this.appID = appID;
    }

    public HashMap<String, String> getPathToWorkfiles() {
        return pathToWorkfiles;
    }

    /**
     * Map of various files specific to the software defined by its appID parameter
     * @param pathToWorkfiles file name:path to file
     */
    public void setPathToWorkfiles(HashMap<String, String> pathToWorkfiles) {
        this.pathToWorkfiles = pathToWorkfiles;
    }

    public HashMap<String, AssetTypes> getPathToAssets() {
        return pathToAssets;
    }

    /**
     * A map of paths including file and there asset types. Defines various resources that are defined by com.pipe42.data.pojos.AssetTypes.
     * @param pathToAssets type of asset:path to file
     * @see com.pipe42.data.pojos.AssetTypes
     */
    public void setPathToAssets(HashMap<String, AssetTypes> pathToAssets) {
        this.pathToAssets = pathToAssets;
    }

    public String getVersionFormat() {
        return versionFormat;
    }

    /**
     * The format in which the version number is part of the file name, eg. vx.xx - "v" for version and x for digits.
     * @param versionFormat Use "x" and or "v" - eg, vX.XX where "x" stands for digits and "v" for version.
     */
    public void setVersionFormat(String versionFormat) {
        this.versionFormat = versionFormat;
    }

    public String getSeparatorChar() {
        return separatorChar;
    }

    /**
     * The single character used as a separator in a file name to distinguish version. Eg. Some_file_v1.00.ma where "_" separates the version. Do NOT use dot "." as separator since it clashes with file extensions as in .ma in the case above.
     * @param separatorChar Single character only. Dot (".") NOT allowed.
     */
    public void setSeparatorChar(String separatorChar) {
        this.separatorChar = separatorChar;
    }

    public HashMap<String, AssetTypeOutput> getPathToOutput() {
        return pathToOutput;
    }

    /**
     * Map of files in output folders as defined by com.pipe42.data.pojos.AssetTypeOutput
     * @param pathToOutput type of output:path to file
     * @see com.pipe42.data.pojos.AssetTypeOutput
     */
    public void setPathToOutput(HashMap<String, AssetTypeOutput> pathToOutput) {
        this.pathToOutput = pathToOutput;
    }

    public String getAssetOwnerID() {
        return assetOwnerID;
    }

    /**
     * The unique owner ID of this specific asset: Derived from com.pipe42.data.pojos.Owner
     * @param assetOwnerID Derived from com.pipe42.data.pojos.Owner
     * @see com.pipe42.data.pojos.Owner
     */
    public void setAssetOwnerID(String assetOwnerID) {
        this.assetOwnerID = assetOwnerID;
    }

    public String getNotes() {
        return notes;
    }

    /**
     *  Any optional notes or comments regarding this asset
     * @param notes UTF-8
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
