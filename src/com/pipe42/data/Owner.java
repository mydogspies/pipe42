package com.pipe42.data;

/**
 * The Owner POJO
 * @author Mydogspies
 *
 */
public final class Owner {
	
	private String name;
	private String company;
	private String department;
	private String projectManager;
	private String notes;

	/* CONSTRUCTORS */
	
	public Owner() {}
	
	public Owner(String name, String company, String department, String projectManager, String notes) {
		this.name = name;
		this.company = company;
		this.department = department;
		this.projectManager = projectManager;
		this.notes = notes;
	}

	/* METHODS */
	
	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public String getDepartment() {
		return department;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public String getNotes() {
		return notes;
	}
	
}
