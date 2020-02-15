package com.pipe42.data;
import java.util.HashMap;

/**
 * Interface for database integration
 * @author Mydogspies
 *
 */
public interface DataRepository {
	
	Object getEntryByID(String id);
	Object getEntryByName(String name);
	HashMap<String, Object> getEntryByProject(String project);
	Project listAllEntries();
	void setEntry(Project project);
	void deleteEntry(String id);

}