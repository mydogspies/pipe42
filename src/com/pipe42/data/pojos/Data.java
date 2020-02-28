package com.pipe42.data.pojos;

import java.util.List;

public final class Data {

    private List<Application> application;
    private List<Project> project;
    private List<Owner> owner;
    private List<Renderengine> engine;

    /* CONSTRUCTORS */

    public Data(List<Project> project, List<Application> application, List<Owner> owner, List<Renderengine> engine) {

        this.application = application;
        this.owner = owner;
        this.project = project;
        this.engine = engine;
    }

    /* GETTERS AND SETTERS */

    public List<Application> getApplication() {

        return application;
    }

    public void setApplication(List<Application> application) {

        this.application = application;
    }

    public List<Project> getProject() {

        return project;
    }

    public void setProject(List<Project> project) {

        this.project = project;
    }

    public List<Owner> getOwner() {

        return owner;
    }

    public void setOwner(List<Owner> owner) {

        this.owner = owner;
    }

    public Data() {
    }

    public List<Renderengine> getEngine() {

        return engine;
    }

    public void setEngine(List<Renderengine> engine) {

        this.engine = engine;
    }
}
