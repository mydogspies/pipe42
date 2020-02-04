package com.pipe42.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pipe42.console.ConsoleOut;

/**
 * IO and call logic for json file as database
 * @author Mydogspies
 *
 */
public class JsonDataIO implements DataIO {
	
	// NOTE: OS specific path but we will run it through a Path method for sanity
	// private static String rawPath = "C:/Users/Student/Desktop/pipe42/src/data/test.json"; // TODO - JsonData - Path should come from preferences
	
	// LOCAL WZB PATH
	private static String rawPath = "M:/30_CODING/01_MIXENV/pipe42/src/data/test.json"; // TODO - JsonData - Path should come from preferences
	// TODO - JsonDataIO - remove when workshop over!!
	
	
	// our Jackson json mapper
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Object getProjectByID(String id) {
		// TODO - JsonData - add getEntryByID
		return null;
	}

	@Override
	public Object getProjectByName(String name) {
		// TODO - JsonData - add getEntryByName
		return null;
	}

	@Override
	public ArrayList<Project> getAllProjects() {
		
		Data content = null;
		ArrayList<Project> listProjects = null;
		
		try {
			content = mapper.readValue(getFileJson(), Data.class);
			listProjects = (ArrayList<Project>) content.getAllProjects();
			ConsoleOut.printCons("JsonData.setEntry read from the Json");
		} catch (JsonParseException e) {
			ConsoleOut.printCons("Json parser failed");
			// TODO - JsonData - add logging
			e.printStackTrace();
		} catch (JsonMappingException e) {
			ConsoleOut.printCons("Json mapper failed");
			// TODO - JsonData - add logging
			e.printStackTrace();
		} catch (IOException e) {
			ConsoleOut.printCons("Writing to json file failed");
			// TODO - JsonData - add logging
			e.printStackTrace();
		}
		
		return listProjects;
	}

	/**
	 * 
	 * Overwrites the json file with a Data POJO
	 * @author Mydogspies
	 */
	@Override
	public void writeAllProjects(Data data) {
		
			try {
				mapper.writeValue(getFileJson(), data);
				ConsoleOut.printCons("JsonData.setEntry write the Json");
			} catch (JsonParseException e) {
				ConsoleOut.printCons("Json parser failed");
				// TODO - JsonData - add logging
				e.printStackTrace();
			} catch (JsonMappingException e) {
				ConsoleOut.printCons("Json mapper failed");
				// TODO - JsonData - add logging
				e.printStackTrace();
			} catch (IOException e) {
				ConsoleOut.printCons("Writing to json file failed");
				// TODO - JsonData - add logging
				e.printStackTrace();
			}
		
	}

	@Override
	public void writeSingleProject(Project project) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteProject(String id) {
		// TODO - JsonData - add deleteEntry
		
	}
	
	/**
	 * Get file object using a non-system specific path
	 * @return returns a file object
	 */
	private File getFileJson() {
		return Paths.get(JsonDataIO.rawPath).toFile();
	}
	
}
