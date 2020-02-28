package com.pipe42.data;

import java.util.ArrayList;
import java.util.List;

// TODO Branch: develop-factory / this is the DatabaseIO interface - once plugged into the main code, take this notice away!

public interface DatabaseIO {

    // info methods
    String getDatabaseInfo();

    // Project methods
    Project getProjectByID(String id);
    Project getProjectByName(String name);
    ArrayList<Project> getAllProjects();
    String getPrefixByName(String prefix);

    // Owner methods
    List<Owner> getAllOwners();
    List<Application> getAllApps();
    List<Renderengine> getAllEngines();

    // write methods
    void writeProject(Project project);
    void writeApplication(Application appdata);
    void writeOwner(Owner owner);
    void writeRenderengine(Renderengine engine);

    // delete methods
    void deleteProject(String id);
    void deleteApplication(String id);
    void deleteQwner(String id);
    void deleteRenderengine(String id);

}
