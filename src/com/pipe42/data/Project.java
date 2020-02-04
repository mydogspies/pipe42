package com.pipe42.data;

import java.time.LocalDateTime;

/**
 * The Project POJO
 * @author Mydogspies
 *
 */
public final class Project {
	
	private String projectId;
	private String projectName;
	private String projectPrefix;
	private Owner owner;
	private Renderengine engine;
	private Application application;
	private String creationTime;
	private String modifyTime;
	private String projectNotes;
	
	
	/* CONSTRUCTORS */
	
	public Project() {}
	
	public Project(String projectId, String projectName, String projectPrefix,
				Owner owner, Renderengine engine, Application application,
				String creationTime, String modifyTime, String projectnotes) {
		
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectPrefix = projectPrefix;
		this.owner = owner;
		this.engine = engine;
		this.application = application;
		this.creationTime = creationTime;
		this.modifyTime = modifyTime;
		this.projectNotes = projectnotes;
	}

	/* METHODS */
	
	public String getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectPrefix() {
		return projectPrefix;
	}

	public Owner getOwner() {
		return owner;
	}

	public Renderengine getEngine() {
		return engine;
	}

	public Application getApplication() {
		return application;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public String getProjectNotes() {
		return projectNotes;
	}

}
