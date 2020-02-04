package com.pipe42.data;

import java.util.ArrayList;

/**
 * Interface for database integration
 * @author Mydogspies
 *
 */
public interface DataIO {
	
	Object getProjectByID(String id);
	Object getProjectByName(String name);
	ArrayList<Project> getAllProjects();
	void writeAllProjects(Data data);
	void writeSingleProject(Project project);
	void deleteProject(String id);

}
