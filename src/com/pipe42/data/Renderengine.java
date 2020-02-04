package com.pipe42.data;

/**
 * The Renderengine POJO
 * @author Mydogspies
 *
 */
public final class Renderengine {
	
	private String engine;
	private String pathToExecutable;
	private String execParams;
	private String engineVersion;
	private String notes;
	
	/* CONSTRUCTORS */
	
	public Renderengine() {}
	
	public Renderengine(String engine, String pathToExecutable, String execParams, String engineVersion, String notes) {
		this.engine = engine;
		this.pathToExecutable = pathToExecutable;
		this.execParams = execParams;
		this.engineVersion = engineVersion;
		this.notes = notes;
	}

	/* METHODS */
	
	public String getEngine() {
		return engine;
	}

	public String getPathToExecutable() {
		return pathToExecutable;
	}

	public String getExecParams() {
		return execParams;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public String getNotes() {
		return notes;
	}
	
	

}
