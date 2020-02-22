package com.pipe42.data;

import java.time.LocalDateTime;
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


	/* CONSTRUCTORS */

	public Project() {}

	public Project(String id, String projectName, String projectPrefix,
				   String ownerID, String engineID, String applicationID,
				   HashMap<String, String> creationTime, HashMap<String, String> modifyTime, String projectnotes) {

		this.projectID = id;
		this.projectName = projectName;
		this.projectPrefix = projectPrefix;
		this.ownerID = ownerID;
		this.engineID = engineID;
		this.applicationID = applicationID;
		this.creationTime = creationTime;
		this.modifyTime = modifyTime;
		this.projectNotes = projectnotes;
	}

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
}
