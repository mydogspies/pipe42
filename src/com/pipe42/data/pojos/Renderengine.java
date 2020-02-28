package com.pipe42.data.pojos;

/**
 * The Renderengine POJO
 * @author Mydogspies
 *
 */
public final class Renderengine {
	
	private String engineID;
	private String engineName;
	private String enginePathToExecutable;
	private String engineExecParams;
	private String engineVersion;
	private String ownerNotes;


	/* CONSTRUCTORS */

	public Renderengine() {}

	public Renderengine(String id, String engineName, String enginePathToExecutable, String engineExecParams, String engineVersion, String ownerNotes) {
		this.engineID = id;
		this.engineName = engineName;
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
	
	public String getEngineName() {

		return engineName;
	}

	public void setEngineName(String engine) {

		this.engineName = engine;
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
