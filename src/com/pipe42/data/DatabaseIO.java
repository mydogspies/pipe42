package com.pipe42.data;

import com.pipe42.data.pojos.Application;
import com.pipe42.data.pojos.Data;
import com.pipe42.data.pojos.Owner;
import com.pipe42.data.pojos.Project;
import com.pipe42.data.pojos.Renderengine;

import java.util.List;

/**
 * This is the interface for our database classes
 * Note that we are using {@com.pipe42.data.DatabaseFactoryProvider} to abstract away the database layer from anything else.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.DatabaseFactoryProvider
 */
public interface DatabaseIO {

    // info methods
    String getDatabaseInfo();

    // Project methods
    List<Project> getAllProjects();
    Project getProjectByID(String id);
    Project getProjectByName(String name);
    Project getProjectByPrefix(String prefix);
    void updateProject(Project newProject);
    void writeProject(Project project);
    void deleteProject(String id);

    // Owner methods
    List<Owner> getAllOwners();
    void writeOwner(Owner owner);
    void deleteQwner(String id);

    // Application methods
    List<Application> getAllApps();
    void writeApplication(Application appdata);
    void deleteApplication(String id);

    // Renderengine methods
    List<Renderengine> getAllEngines();
    void writeRenderengine(Renderengine engine);
    void deleteRenderengine(String id);

    // Asset methods
    // TODO add the new Asset methods (0.2.0)

    // general methods
    Boolean writeAll(Data data);

}
