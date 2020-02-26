package com.pipe42.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for database integration
 * @author Mydogspies
 *
 */
public interface DataIO {

	// Project methods
	Project getProjectByID(String id);
	Project getProjectByName(String name);
	ArrayList<Project> getAllProjects();

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
