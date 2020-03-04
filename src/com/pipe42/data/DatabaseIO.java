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
    Project getProjectByID(String id);
    Project getProjectByName(String name);
    List<Project> getAllProjects();
    Project getProjectByPrefix(String prefix);

    // Owner methods
    List<Owner> getAllOwners();
    List<Application> getAllApps();
    List<Renderengine> getAllEngines();

    // write methods
    void writeProject(Project project);
    void writeApplication(Application appdata);
    void writeOwner(Owner owner);
    void writeRenderengine(Renderengine engine);
    Boolean writeAll(Data data);

    // delete methods
    void deleteProject(String id);
    void deleteApplication(String id);
    void deleteQwner(String id);
    void deleteRenderengine(String id);

}
