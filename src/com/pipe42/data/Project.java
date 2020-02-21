package com.pipe42.data;

import java.time.LocalDateTime;

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
	private LocalDateTime creationTime;
	private LocalDateTime modifyTime;
	private String projectNotes;


	/* CONSTRUCTORS */

	public Project() {}

	public Project(String id, String projectName, String projectPrefix,
				   String ownerID, String engineID, String applicationID,
				   LocalDateTime creationTime, LocalDateTime modifyTime, String projectnotes) {

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

	public LocalDateTime getCreationTime() {

		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {

		this.creationTime = creationTime;
	}

	public LocalDateTime getModifyTime() {

		return modifyTime;
	}

	public void setModifyTime(LocalDateTime modifyTime) {
		this.modifyTime = modifyTime;
	}
}
