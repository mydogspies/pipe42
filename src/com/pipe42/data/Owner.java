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

	/* GETTERS AND SETTERS */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
