package com.pipe42.data;

import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Data;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;

import java.util.List;

public class DatabaseSQLite implements DatabaseIO {


    @Override
    public String getDatabaseInfo() {
        return null;
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
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Project getProjectByPrefix(String prefix) {
        return null;
    }

    @Override
    public void updateProject(Project newProject) {

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
    public Boolean writeAll(Data data) {
        return null;
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
