package com.pipe42.data;
import java.util.HashMap;

public interface DataRepository {
	
	Object getEntryByID(String id);
	Object getEntryByName(String name);
	HashMap<String, Object> getEntryByProject(String project);
	HashMap<String, Object> listAllEntries();
	void updateEntry(String id);
	void deleteEntry(String id);

}
