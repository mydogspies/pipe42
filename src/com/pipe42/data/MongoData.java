package com.pipe42.data;

import java.util.HashMap;

/**
 * Implementation of mongoDB Java driver
 * @author Mydogspies
 *
 */
public class MongoData implements DataRepository {

	@Override
	public Object getEntryByID(String id) {
		// TODO - MongoData - add getEntryByID
		return null;
	}

	@Override
	public Object getEntryByName(String name) {
		// TODO - MongoData - add getEntryByName
		return null;
	}

	@Override
	public HashMap<String, Object> getEntryByProject(String project) {
		// TODO - MongoData - add getEntryByProject
		return null;
	}

	@Override
	public Project listAllEntries() {
		// TODO - MongoData - add listAllEntries
		return null;
	}

	@Override
	public void setEntry(Project project) {
		// TODO - MongoData - add updateEntry
		
	}

	@Override
	public void deleteEntry(String id) {
		// TODO - MongoData - add deleteEntry
		
	}

	
}