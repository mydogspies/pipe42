package com.pipe42.data.pojos;

import java.util.List;

/**
 * This is the Data model object used in the DAO.
 * This specific POJO is mainly used for Json in combination with the Jackson library
 * and as an unified object to be used in non-relational databases.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.DatabaseJson
 * @see <a href="https://github.com/FasterXML/jackson">Jackson Project Home @ github</a>
 */
public final class Data {

    private List<Application> application;
    private List<Project> project;
    private List<Owner> owner;
    private List<Renderengine> engine;


    /* CONSTRUCTORS */

    /**
     * Empty constructor is only used for external libraries that rely on a default definition
     */
    public Data() {}

    /**
     * Constructor for a unified model object that contains all other model objects. Used primarily with Json and non-relational databases.
     */
    public Data(List<Project> project, List<Application> application, List<Owner> owner, List<Renderengine> engine) {

        this.application = application;
        this.owner = owner;
        this.project = project;
        this.engine = engine;
    }


    /* GETTERS AND SETTERS */

    /**
     * A list of objects derived from the Application model object com.pipe42.data.pojos.Application
     * @param application a list of Application objects
     * @see com.pipe42.data.pojos.Application
     */
    public void setApplication(List<Application> application) {

        this.application = application;
    }

    public List<Application> getApplication() {

        return application;
    }

    /**
     * A list of objects derived from the Project model object com.pipe42.data.pojos.Project
     * @param project a list of Project objects
     * @see com.pipe42.data.pojos.Project
     */
    public void setProject(List<Project> project) {

        this.project = project;
    }

    public List<Project> getProject() {

        return project;
    }

    /**
     * A list of objects derived from the Owner model object com.pipe42.data.pojos.Owner
     * @param owner a list of Owner objects
     * @see com.pipe42.data.pojos.Owner
     */
    public void setOwner(List<Owner> owner) {

        this.owner = owner;
    }

    public List<Owner> getOwner() {

        return owner;
    }

    /**
     * A list of objects derived from the Owner model object com.pipe42.data.pojos.Renderengine
     * @param engine a list of Renderengine objects
     * @see com.pipe42.data.pojos.Renderengine
     */
    public void setEngine(List<Renderengine> engine) {

        this.engine = engine;
    }

    public List<Renderengine> getEngine() {

        return engine;
    }
}
