package com.pipe42.data.pojos;

import java.util.HashMap;

/**
 * This is the Project model object used in the DAO.
 * It defines the Project details themselves and adds together the IDs from other objects that belong to this project.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.pojos.Data
 */
public final class Project {
	
	private String projectID;
	private String projectName;
	private String projectPrefix;
	private String ownerID;
	private String engineID;
	private String applicationID;
	private HashMap<String, String> creationTime;
	private HashMap<String, String> modifyTime;
	private String notes;
	private String projectTemplate;
	private String projectPath;


	/* CONSTRUCTORS */

	/**
	 * Empty constructor is only used for external libraries that rely on a default definition
	 */
	public Project() {}

	/**
	 * The default constructor for this object
	 */
	public Project(String id, String projectName, String projectPrefix,
				   String ownerID, String engineID, String applicationID,
				   HashMap<String, String> creationTime, HashMap<String, String> modifyTime,
				   String projectnotes, String projectTemplate, String projectPath) {

		this.projectID = id;
		this.projectName = projectName;
		this.projectPrefix = projectPrefix;
		this.ownerID = ownerID;
		this.engineID = engineID;
		this.applicationID = applicationID;
		this.creationTime = creationTime;
		this.modifyTime = modifyTime;
		this.notes = projectnotes;
		this.projectTemplate = projectTemplate;
		this.projectPath = projectPath;
	}


	/* GETTERS AND SETTERS */

	public String getProjectID() {

		return projectID;
	}

	/**
	 * The unique hash ID of this object
	 * @param projectID Derived from com.pipe42.util.Util
	 * @see com.pipe42.util.Util
	 */
	public void setProjectID(String projectID) {

		this.projectID = projectID;
	}

	public String getProjectName() {

		return projectName;
	}

	/**
	 * Name of the project. This name must be unique and two projects can not share the same name.
	 * @param projectName Unique name of the project
	 */
	public void setProjectName(String projectName) {

		this.projectName = projectName;
	}

	public String getProjectPrefix() {

		return projectPrefix;
	}

	/**
	 * The prefix that is used in the file naming convention. It must be unique and two projects can not share the same prefix.
	 * @param projectPrefix Unique prefix for this project. The max amount of characters is set in user preferences.
	 */
	public void setProjectPrefix(String projectPrefix) {

		this.projectPrefix = projectPrefix;
	}

	public String getOwnerID() {

		return ownerID;
	}

	/**
	 * The unique ID hash of the Owner object associated with this particular project.
	 * @param ownerID the ID of the project owner
	 * @see com.pipe42.data.pojos.Owner
	 */
	public void setOwnerID(String ownerID) {

		this.ownerID = ownerID;
	}

	public String getEngineID() {

		return engineID;
	}

	/**
	 * The unique ID hash of the Renderengine associated with this particular project.
	 * @param engineID the ID of the Renderengine
	 * @see com.pipe42.data.pojos.Renderengine
	 */
	public void setEngineID(String engineID) {

		this.engineID = engineID;
	}

	public String getApplicationID() {

		return applicationID;
	}

	/**
	 * The unique ID hash of the Application software that is associated with this particular project.
	 * @param applicationID the ID of the Application
	 * @see com.pipe42.data.pojos.Application
	 */
	public void setApplicationID(String applicationID) {

		this.applicationID = applicationID;
	}

	public String getNotes() {

		return notes;
	}

	/**
	 * Notes or comments regarding this project
	 * @param notes Optional notes or commments
	 */
	public void setNotes(String notes) {

		this.notes = notes;
	}

	public HashMap<String, String> getCreationTime() {

		return creationTime;
	}

	/**
	 * Formatted map of date and exact time when this project object was first created.
	 * @param creationTime In the format key:val - (date:current date) and (time:current time)
	 * @see com.pipe42.util.Util
	 */
	public void setCreationTime(HashMap<String, String> creationTime) {

		this.creationTime = creationTime;
	}

	public HashMap<String, String> getModifyTime() {

		return modifyTime;
	}

	/**
	 * Formatted map of date and exact time when this project object was last modified.
	 * @param modifyTime In the format key:val - (date:current date) and (time:current time)
	 * @see com.pipe42.util.Util
	 */
	public void setModifyTime(HashMap<String, String> modifyTime) {

		this.modifyTime = modifyTime;
	}

	public String getProjectTemplate() {
		return projectTemplate;
	}

	/**
	 * The template used for creating the project folder structure on disc.
	 * This parameter is based off the template file names in the data/templates folder in the root of the source files.
	 * @param projectTemplate The unique name of a folder structure template
	 * @see com.pipe42.data.Xml
	 */
	public void setProjectTemplate(String projectTemplate) {
		this.projectTemplate = projectTemplate;
	}

	public String getProjectPath() {
		return projectPath;
	}

	/**
	 * The absolute path of the root where the project folders reside.
	 * The folder structure as defined by {@setProjectTemplate} resides directly within this root and the root should
	 * also contain the unique file .pipe42 to verify this is a valid project root.
	 * @param projectPath the unique absolute path to this project's root where all folders reside
	 * @see com.pipe42.data.Xml
	 */
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
}
