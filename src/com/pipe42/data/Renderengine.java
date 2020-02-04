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

	/* GETTERS AND SETTERS */
	
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getPathToExecutable() {
		return pathToExecutable;
	}

	public void setPathToExecutable(String pathToExecutable) {
		this.pathToExecutable = pathToExecutable;
	}

	public String getExecParams() {
		return execParams;
	}

	public void setExecParams(String execParams) {
		this.execParams = execParams;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
