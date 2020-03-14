package com.pipe42.data.pojos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This is the Owner model object used in the DAO.
 * It defines the owner/manager and/or the organisation that is responsible for this particular project.
 *
 * @author Peter Mankowski
 * @see com.pipe42.data.pojos.Data
 * @since 0.1.0
 */
@JsonPropertyOrder({"ownerID", "ownerName", "ownerCompany", "ownerDepartment", "projectManager", "notes"})
public final class Owner {

    private String ownerID;
    private String ownerName;
    private String ownerCompany;
    private String ownerDepartment;
    private String projectManager;
    private String notes;


    /* CONSTRUCTORS */

    /**
     * Empty constructor is only used for external libraries that rely on a default definition
     */
    public Owner() {
    }

    /**
     * The default constructor for this object.
     */
    public Owner(String id, String ownerName, String ownerCompany, String ownerDepartment, String projectManager, String notes) {
        this.ownerID = id;
        this.ownerName = ownerName;
        this.ownerCompany = ownerCompany;
        this.ownerDepartment = ownerDepartment;
        this.projectManager = projectManager;
        this.notes = notes;
    }

    /* GETTERS AND SETTERS */

    public String getOwnerId() {
        return ownerID;
    }

    /**
     * Unique has ID for this owner object
     *
     * @param ownerId Derived from com.pipe42.util.Util
     * @see com.pipe42.util.Util
     */
    public void setOwnerId(String ownerId) {
        this.ownerID = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /**
     * The name of the project owner or organisation to whom the project belongs
     *
     * @param ownerName Name of owner/organisation
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCompany() {
        return ownerCompany;
    }

    /**
     * The name of the company/organisation to which the project belongs. Can be the same as ownerName
     *
     * @param ownerCompany Optional name of company/organisation
     */
    public void setOwnerCompany(String ownerCompany) {
        this.ownerCompany = ownerCompany;
    }

    public String getOwnerDepartment() {
        return ownerDepartment;
    }

    /**
     * The department or organisational level the project belongs to
     *
     * @param ownerDepartment Optional name of department
     */
    public void setOwnerDepartment(String ownerDepartment) {
        this.ownerDepartment = ownerDepartment;
    }

    public String getProjectManager() {
        return projectManager;
    }

    /**
     * Name of the project manager or head of this project. Can be the same as ownerName.
     *
     * @param projectManager Optional name of project manager
     */
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getNotes() {
        return notes;
    }

    /**
     * Notes or comments regarding the organisation or managers/owners
     *
     * @param notes Optional notes and comments
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

}
