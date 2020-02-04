package com.pipe42.data;

import java.util.List;

public final class Data {
	
	private List<Project> allProjects;

	/* CONSTRUCTORS */
	
	public Data() {}
	
	public Data(List<Project> allProjects) {
		this.allProjects = allProjects;
	}

	/* GETTERS AND SETTERS */
	
	public List<Project> getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}

}
