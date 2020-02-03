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
	private LocalDateTime creationTime;
	private LocalDateTime modifyTime;
	private String projectNotes;
	
	
	/* CONSTRUCTORS */
	
	public Project() {}
	
	public Project(String projectId, String projectName, String projectPrefix,
				Owner owner, Renderengine engine, Application application,
				LocalDateTime creationTime, LocalDateTime modifyTime, String projectnotes) {
		
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
	
	// TODO - Project - Finish POJO methods
	
}
