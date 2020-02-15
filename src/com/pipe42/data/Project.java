package com.pipe42.data;

/**
 * The Project POJO
 * @author Mydogspies
 *
 */
public final class Project {
	
	private String projectID;
	private String projectName;
	private String projectPrefix;
	private Owner owner;
	private Renderengine engine;
	private Application application;
	private String creationTime;
	private String modifyTime;
	private String notes;
	
	
	/* CONSTRUCTORS */
	
	public Project() {}
	
	public Project(String id, String projectName, String projectPrefix,
				Owner owner, Renderengine engine, Application application,
				String creationTime, String modifyTime, String projectnotes) {
		
		this.projectID = id;
		this.projectName = projectName;
		this.projectPrefix = projectPrefix;
		this.owner = owner;
		this.engine = engine;
		this.application = application;
		this.creationTime = creationTime;
		this.modifyTime = modifyTime;
		this.notes = projectnotes;
	}

	/* GETTERS AND SETTERS */
	
	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectId) {
		this.projectID = projectId;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Renderengine getEngine() {
		return engine;
	}

	public void setEngine(Renderengine engine) {
		this.engine = engine;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getProjectNotes() {
		return notes;
	}

	public void setProjectNotes(String projectNotes) {
		this.notes = projectNotes;
	}

}
