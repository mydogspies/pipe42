package com.pipe42.data.pojos;

/**
 * The Owner POJO
 * @author Mydogspies
 *
 */
public final class Owner {
	
	private String ownerID;
	private String ownerName;
	private String ownerCompany;
	private String ownerDepartment;
	private String projectManager;
	private String ownerNotes;

	/* CONSTRUCTORS */

	public Owner() {}

	public Owner(String id, String ownerName, String ownerCompany, String ownerDepartment, String projectManager, String ownerNotes) {
		this.ownerID = id;
		this.ownerName = ownerName;
		this.ownerCompany = ownerCompany;
		this.ownerDepartment = ownerDepartment;
		this.projectManager = projectManager;
		this.ownerNotes = ownerNotes;
	}

	/* GETTERS AND SETTERS */
	
	public String getOwnerId() {
		return ownerID;
	}

	public void setOwnerId(String ownerId) {
		this.ownerID = ownerId;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerCompany() {
		return ownerCompany;
	}

	public void setOwnerCompany(String ownerCompany) {
		this.ownerCompany = ownerCompany;
	}

	public String getOwnerDepartment() {
		return ownerDepartment;
	}

	public void setOwnerDepartment(String ownerDepartment) {
		this.ownerDepartment = ownerDepartment;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getOwnerNotes() {
		return ownerNotes;
	}

	public void setOwnerNotes(String ownerNotes) {
		this.ownerNotes = ownerNotes;
	}

}
