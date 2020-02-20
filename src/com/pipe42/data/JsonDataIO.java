package com.pipe42.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
	
	// NOTE: path is relative from root, eg. src/....
	// TODO - JsonData - Path should come from preferences and notes must be updated
	private static String rawPath = "src/data/data.json";

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
	public ArrayList<Object> getAllProjects() {
		return null;
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
	 * Appends an entry of type Application into the data.json file
	 * @param appData list of entries of type Application
	 */
	@Override
	public void writeApplication(Application appData) {

		// get current database from json.data
		Data database = getJsonData();

		// and then add it to current list of Application objects
		List<Application> appList = database.getApplication();
		appList.add(appData);

		// add all back together
		Data container = new Data(database.getProject(), appList, database.getOwner());

		// and write the new Data object to json.data
		try {
			mapper.writeValue(getFileJson(), container);
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

	/**
	 * Reads the json.data file and returns a Data object with the entire object
	 * @return an object of type Data
	 */
	private Data getJsonData() {

		Data content = null;

		try {
			content = mapper.readValue(getFileJson(), Data.class);
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
			ConsoleOut.printCons("Reading from json file failed");
			// TODO - JsonData - add logging
			e.printStackTrace();
		}

		return content;
	}

	// TODO should live in com.pipe42.util
	/**
	 * Get file object using a non-system specific path
	 * @return returns a file object
	 */
	private File getFileJson() {

		return Paths.get(JsonDataIO.rawPath).toFile();
	}
	
}
