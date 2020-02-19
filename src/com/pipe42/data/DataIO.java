package com.pipe42.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for database integration
 * @author Mydogspies
 *
 */
public interface DataIO {
	
	Object getProjectByID(String id);
	Object getProjectByName(String name);
	ArrayList<Object> getAllProjects();
	void writeSingleProject(Project project);
	void deleteProject(String id);
	// TODO new methods - delete this line once it's all cleaned up
	void writeApplication(Application appdata);

}
