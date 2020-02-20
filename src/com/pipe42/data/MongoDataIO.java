package com.pipe42.data;

import java.util.ArrayList;

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
	public ArrayList<Object> getAllProjects() {
		return null;
	}

	@Override
	public ArrayList<Owner> getAllOwners() {
		return null;
	}

	@Override
	public void writeProject(Project project) {

	}

	@Override
	public void deleteProject(String id) {
		// TODO - MongoData - add deleteEntry
		
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

	@Override
	public void writeApplication(Application appdata) {
		// TODO add writeApplication
	}

	@Override
	public void writeOwner(Owner owner) {

	}

	@Override
	public void writeRenderengine(Renderengine engine) {

	}

}
