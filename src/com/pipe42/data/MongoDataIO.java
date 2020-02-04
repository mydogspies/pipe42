package com.pipe42.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implementation of mongoDB Java driver
 * @author Mydogspies
 *
 */
public class MongoDataIO implements DataIO {

	@Override
	public Object getProjectByID(String id) {
		// TODO - MongoData - add getEntryByID
		return null;
	}

	@Override
	public Object getProjectByName(String name) {
		// TODO - MongoData - add getEntryByName
		return null;
	}

	@Override
	public ArrayList<Project> getAllProjects() {
		// TODO - MongoData - add listAllEntries
		return null;
	}

	@Override
	public void writeAllProjects(Data data) {
		// TODO - MongoData - add updateEntry
		
	}

	@Override
	public void writeSingleProject(Project project) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deleteProject(String id) {
		// TODO - MongoData - add deleteEntry
		
	}

}
