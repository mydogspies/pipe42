package com.pipe42.data;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pipe42.console.ConsoleOut;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Implementation of Jackson bindings for Json
 * @author Mydogspies
 *
 */
public class JsonData implements DataRepository {
	
	// NOTE: OS specific path but we will run it through a Path method for sanity
	// private static String rawPath = "C:/Users/Student/Desktop/pipe42/src/data/test.json"; // TODO - JsonData - Path should come from preferences
	
	// Alternative to above for workshop ONLY
	private static String rawPath = "C:/Users/Student/Desktop/pipe42/src/data/test.json"; // TODO - JsonData - Path should come from preferences
	// TODO - JsonData - remove this path at the end of workshop
	
	// our Jackson json mapper
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Object getEntryByID(String id) {
		// TODO - JsonData - add getEntryByID
		return null;
	}

	@Override
	public Object getEntryByName(String name) {
		// TODO - JsonData - add getEntryByName
		return null;
	}

	@Override
	public HashMap<String, Object> getEntryByProject(String project) {
		// TODO - JsonData - add getEntryByProject
		return null;
	}

	@Override
	public Project listAllEntries() {
		
		Project content = null;
		
		try {
			content = mapper.readValue(getFileJson(), Project.class);
			ConsoleOut.printCons("JsonData.setEntry read from the Json");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return content;
	}

	@Override
	public void setEntry(Project project) {
		
		try {
			mapper.writeValue(getFileJson(), project);
			ConsoleOut.printCons("JsonData.setEntry write the Json");
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEntry(String id) {
		// TODO - JsonData - add deleteEntry
		
	}
	
	/**
	 * Get file object using a non-system specific path
	 * @return returns a file object
	 */
	private File getFileJson() {
		File sysObtainedFile = Paths.get(this.rawPath).toFile();
		return sysObtainedFile;
	}

	
	
}
