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


	/* IMPLEMENTED METHODS */

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

	/**
	 * Get all Owner objects and return a List thereof
	 * @return returns a List of type Owner
	 */
	@Override
	public List<Owner> getAllOwners() {

		Data database = getJsonData();
		return database.getOwner();
	}

	/**
	 * Get all Application objects and return a List thereof
	 * @return returns List of type Application
	 */
	@Override
	public List<Application> getAllApps() {

		Data database = getJsonData();
		return database.getApplication();
	}

	/**
	 * Get all Renderengine objects and return a List thereof
	 * @return returns List of type Renderengine
	 */
	@Override
	public List<Renderengine> getAllEngines() {

		Data database = getJsonData();
		return database.getEngine();
	}

	@Override
	public void deleteProject(String id) {
		// TODO - JsonData - add deleteEntry
		
	}

	@Override
	public void deleteApplication(String id) {

	}

	@Override
	public void deleteQwner(String id) {

	}

	@Override
	public void deleteRenderengine(String id) {

	}

	/**
	 * Appends an entry of type Project into the data.json file
	 * @param project list of entries of type Project
	 */
	@Override
	public void writeProject(Project project) {

		// get current database from json.data
		Data database = getJsonData();

		// and then add it to current list of Application objects
		List<Project> projectList = database.getProject();
		projectList.add(project);

		Data container = new Data(projectList, database.getApplication(), database.getOwner(), database.getEngine());

		writeJsonData(container);

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

		Data container = new Data(database.getProject(), appList, database.getOwner(), database.getEngine());

		writeJsonData(container);

	}

	/**
	 * Appends an entry of type Owner into the data.json file
	 * @param owner list of entries of type Owner
	 */
	@Override
	public void writeOwner(Owner owner) {

		// get current database from json.data
		Data database = getJsonData();

		// and then add it to current list of Application objects
		List<Owner> ownerList = database.getOwner();
		ownerList.add(owner);

		Data container = new Data(database.getProject(), database.getApplication(), ownerList, database.getEngine());

		writeJsonData(container);

	}

	/**
	 * Appends an entry of type Renderengine into the data.json file
	 * @param engine list of entries of type Renderengine
	 */
	@Override
	public void writeRenderengine(Renderengine engine) {

		// get current database from json.data
		Data database = getJsonData();

		// and then add it to current list of Application objects
		List<Renderengine> engineList = database.getEngine();
		engineList.add(engine);

		Data container = new Data(database.getProject(), database.getApplication(), database.getOwner(), engineList);

		writeJsonData(container);

	}


	/* LOCAL METHODS */

	/**
	 * Constructs a Json file (overwrites) with data contained in the Data object
	 * in the path defined by getFileJson
	 * @param data an object of type Data
	 */
	public void writeJsonData(Data data) { // TODO change to private when tests done

		// and write the new Data object to json.data
		try {
			mapper.writeValue(getFileJson(), data);
			ConsoleOut.printCons("Data successfully written to Json file");
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
			ConsoleOut.printCons("Data successfully read from Json file.");
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
