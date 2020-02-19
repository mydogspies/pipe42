package com.pipe42.data;

/**
 * The Renderengine POJO
 * @author Mydogspies
 *
 */
public final class Renderengine {
	
	private String engineID;
	private String engine;
	private String enginePathToExecutable;
	private String engineExecParams;
	private String engineVersion;
	private String ownerNotes;
	
	/* CONSTRUCTORS */
	
	public Renderengine(String id, String engine, String enginePathToExecutable, String engineExecParams, String engineVersion, String ownerNotes) {
		this.engineID = id;
		this.engine = engine;
		this.enginePathToExecutable = enginePathToExecutable;
		this.engineExecParams = engineExecParams;
		this.engineVersion = engineVersion;
		this.ownerNotes = ownerNotes;
	}

	/* GETTERS AND SETTERS */
	
	public String getEngineID() {
		return engineID;
	}

	public void setEngineID(String engineID) {
		this.engineID = engineID;
	}
	
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getEnginePathToExecutable() {
		return enginePathToExecutable;
	}

	public void setEnginePathToExecutable(String enginePathToExecutable) {
		this.enginePathToExecutable = enginePathToExecutable;
	}

	public String getEngineExecParams() {
		return engineExecParams;
	}

	public void setEngineExecParams(String engineExecParams) {
		this.engineExecParams = engineExecParams;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	public String getOwnerNotes() {
		return ownerNotes;
	}

	public void setOwnerNotes(String ownerNotes) {
		this.ownerNotes = ownerNotes;
	}

}
