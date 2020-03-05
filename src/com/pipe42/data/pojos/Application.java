package com.pipe42.data.pojos;

/**
 * This is the Application model object used by our DAO.
 * @author Peter Mankowski
 * @since 0.1.0
 * @see com.pipe42.data.pojos.Data
 *
 */
public final class Application {
	
	private String appID;
	private String appName;
	private String appVersion;
	private String appPathToExecutable;
	private String appExecParams;
	private String notes;
	
	/* CONSTRUCTORS */

	/**
	 * Empty constructor is only used for external libraries that rely on a default definition
	 */
	public Application() {}

	/**
	 * The default constructor for this object
	 */
	public Application(String id, String appName, String appVersion, String appPathToExecutable, String appExecParams, String notes) {
		this.appID = id;
		this.appName = appName;
		this.appVersion = appVersion;
		this.appPathToExecutable = appPathToExecutable;
		this.appExecParams = appExecParams;
		this.notes = notes;
	}

	/* GETTERS AND SETTERS */
	
	public String getAppID() {

		return appID;
	}

	/**
	 * The unique hash ID of this object.
	 * @param appID Derived from com.pipe42.util.Util.
	 * @see com.pipe42.util.Util
	 */
	public void setAppID(String appID) {

		this.appID = appID;
	}

	public String getAppName() {

		return appName;
	}

	/**
	 * The name of the main software application in this project to which the work/master files belong to.
	 * @param appName Name of software application.
	 */
	public void setAppName(String appName) {

		this.appName = appName;
	}

	public String getAppVersion() {

		return appVersion;
	}

	/**
	 * The version of the application software used in this project.
	 * @param appVersion Software version.
	 */
	public void setAppVersion(String appVersion) {

		this.appVersion = appVersion;
	}

	public String getAppPathToExecutable() {

		return appPathToExecutable;
	}

	/**
	 * The absolute path to the executable of the application software.
	 * @param appPathToExecutable Absolute path to executable.
	 */
	public void setAppPathToExecutable(String appPathToExecutable) {

		this.appPathToExecutable = appPathToExecutable;
	}

	public String getAppExecParams() {

		return appExecParams;
	}
	/**
	 * Optional command line arguments passed in the call to the executable.
	 * eg. "Maya -help" where "-help" would be the parameter passed here.
	 * @param appExecParams optional arguments passed to the executable
	 */
	public void setAppExecParams(String appExecParams) {

		this.appExecParams = appExecParams;
	}

	public String getNotes() {

		return notes;
	}

	/**
	 * Optional notes or comments regarding this software.
	 * @param notes Notes or comments.
	 */
	public void setNotes(String notes) {

		this.notes = notes;
	}

}
