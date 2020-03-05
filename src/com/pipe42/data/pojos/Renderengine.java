package com.pipe42.data.pojos;

/**
 * This is the Renderengine model object used in the DAO.
 * It defines the main Renderengine this project uses.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.pojos.Data
 */
public final class Renderengine {
	
	private String engineID;
	private String engineName;
	private String enginePathToExecutable;
	private String engineExecParams;
	private String engineVersion;
	private String notes;


	/* CONSTRUCTORS */

	/**
	 * Empty constructor is only used for external libraries that rely on a default definition.
	 */
	public Renderengine() {}

	/**
	 * The default constructor for this object.
	 */
	public Renderengine(String id, String engineName, String enginePathToExecutable, String engineExecParams, String engineVersion, String notes) {
		this.engineID = id;
		this.engineName = engineName;
		this.enginePathToExecutable = enginePathToExecutable;
		this.engineExecParams = engineExecParams;
		this.engineVersion = engineVersion;
		this.notes = notes;
	}

	/* GETTERS AND SETTERS */
	
	public String getEngineID() {

		return engineID;
	}

	/**
	 * The unique hash ID of this object.
	 * @param engineID Derived from com.pipe42.util.Util.
	 * @see com.pipe42.util.Util
	 */
	public void setEngineID(String engineID) {

		this.engineID = engineID;
	}
	
	public String getEngineName() {

		return engineName;
	}

	/**
	 * The name of the render engine/software.
	 * @param engine Name of render engine.
	 */
	public void setEngineName(String engine) {

		this.engineName = engine;
	}

	public String getEnginePathToExecutable() {

		return enginePathToExecutable;
	}

	/**
	 * The absolute path to the executable of the render engine.
	 * @param enginePathToExecutable Absolute path to executable.
	 */
	public void setEnginePathToExecutable(String enginePathToExecutable) {

		this.enginePathToExecutable = enginePathToExecutable;
	}

	public String getEngineExecParams() {

		return engineExecParams;
	}

	/**
	 * Optional command line arguments passed in the call to the executable.
	 * eg. "Render -help" where "-help" would be the parameter passed here.
	 * @param engineExecParams optional arguments passed to the executable
	 */
	public void setEngineExecParams(String engineExecParams) {

		this.engineExecParams = engineExecParams;
	}

	public String getEngineVersion() {

		return engineVersion;
	}

	/**
	 * The version of the render engine software used for this particular project.
	 * @param engineVersion The version of the software used.
	 */
	public void setEngineVersion(String engineVersion) {

		this.engineVersion = engineVersion;
	}

	public String getNotes() {

		return notes;
	}

	/**
	 * Optional notes or comments regarding this render engine.
	 * @param notes Notes or comments.
	 */
	public void setNotes(String notes) {

		this.notes = notes;
	}

}
