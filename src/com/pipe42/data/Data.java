package com.pipe42.data;

import java.util.Date;
import java.util.List;

public final class Data {

    private List<Application> application;
    private List<Project> project;
    private List<Owner> owner;

    /* CONSTRUCTORS */

    public Data(List<Project> project, List<Application> application, List<Owner> owner) {

        this.application = application;
        this.owner = owner;
        this.project = project;
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
}
