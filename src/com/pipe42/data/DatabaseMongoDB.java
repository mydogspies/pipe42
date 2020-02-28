package com.pipe42.data;

import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;

import java.util.ArrayList;
import java.util.List;

// TODO Branch: develop-factory / this is the implementation of DatabaseIO interface - once plugged into the main code, take this notice away!

public class DatabaseMongoDB implements DatabaseIO {

    @Override
    public String getDatabaseInfo() {

        // TODO implement a proper info

        return "MongoDB";
    }

    @Override
    public Project getProjectByID(String id) {
        return null;
    }

    @Override
    public Project getProjectByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Project> getAllProjects() {
        return null;
    }

    @Override
    public String getPrefixByName(String prefix) {
        return null;
    }

    @Override
    public List<Owner> getAllOwners() {
        return null;
    }

    @Override
    public List<Application> getAllApps() {
        return null;
    }

    @Override
    public List<Renderengine> getAllEngines() {
        return null;
    }

    @Override
    public void writeProject(Project project) {

    }

    @Override
    public void writeApplication(Application appdata) {

    }

    @Override
    public void writeOwner(Owner owner) {

    }

    @Override
    public void writeRenderengine(Renderengine engine) {

    }

    @Override
    public void deleteProject(String id) {

    }

    @Override
    public void deleteApplication(String id) {

    }

    @Override
    public void deleteQwner(String id) {

    }

    @Override
    public void deleteRenderengine(String id) {

    }
}
