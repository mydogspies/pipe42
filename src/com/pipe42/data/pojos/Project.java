package com.pipe42.data.pojos;

import org.python.antlr.ast.Str;

import java.util.HashMap;

/**
 * The Project POJO
 * @author Mydogspies
 *
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
	private String projectNotes;
	private String projectTemplate;
	private String projectPath;


	/* CONSTRUCTORS */

	public Project() {}

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
		this.projectNotes = projectnotes;
		this.projectTemplate = projectTemplate;
		this.projectPath = projectPath;
	}


	/* GETTERS AND SETTERS */

	public String getProjectID() {

		return projectID;
	}

	public void setProjectID(String projectID) {

		this.projectID = projectID;
	}

	public String getProjectName() {

		return projectName;
	}

	public void setProjectName(String projectName) {

		this.projectName = projectName;
	}

	public String getProjectPrefix() {

		return projectPrefix;
	}

	public void setProjectPrefix(String projectPrefix) {

		this.projectPrefix = projectPrefix;
	}

	public String getOwnerID() {

		return ownerID;
	}

	public void setOwnerID(String ownerID) {

		this.ownerID = ownerID;
	}

	public String getEngineID() {

		return engineID;
	}

	public void setEngineID(String engineID) {

		this.engineID = engineID;
	}

	public String getApplicationID() {

		return applicationID;
	}

	public void setApplicationID(String applicationID) {

		this.applicationID = applicationID;
	}

	public String getProjectNotes() {

		return projectNotes;
	}

	public void setProjectNotes(String projectNotes) {

		this.projectNotes = projectNotes;
	}

	public HashMap<String, String> getCreationTime() {

		return creationTime;
	}

	public void setCreationTime(HashMap<String, String> creationTime) {

		this.creationTime = creationTime;
	}

	public HashMap<String, String> getModifyTime() {

		return modifyTime;
	}

	public void setModifyTime(HashMap<String, String> modifyTime) {

		this.modifyTime = modifyTime;
	}

	public String getProjectTemplate() {
		return projectTemplate;
	}

	public void setProjectTemplate(String projectTemplate) {
		this.projectTemplate = projectTemplate;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
}
