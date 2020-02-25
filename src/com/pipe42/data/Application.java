package com.pipe42.data;

/**
 * The Application POJO
 * @author Mydogspies
 *
 */
public final class Application {
	
	private String appID;
	private String appName;
	private String appVersion;
	private String appPathToExecutable;
	private String appExecParams;
	private String appNotes;
	
	/* CONSTRUCTORS */

	public Application() {}

	public Application(String id, String appName, String appVersion, String appPathToExecutable, String appExecParams, String notes) {
		this.appID = id;
		this.appName = appName;
		this.appVersion = appVersion;
		this.appPathToExecutable = appPathToExecutable;
		this.appExecParams = appExecParams;
		this.appNotes = notes;
	}

	/* GETTERS AND SETTERS */
	
	public String getAppID() {

		return appID;
	}

	public void setAppID(String appID) {

		this.appID = appID;
	}
	
	public String getAppName() {

		return appName;
	}

	public void setAppName(String appName) {

		this.appName = appName;
	}

	public String getAppVersion() {

		return appVersion;
	}

	public void setAppVersion(String appVersion) {

		this.appVersion = appVersion;
	}

	public String getAppPathToExecutable() {

		return appPathToExecutable;
	}

	public void setAppPathToExecutable(String appPathToExecutable) {

		this.appPathToExecutable = appPathToExecutable;
	}

	public String getAppExecParams() {

		return appExecParams;
	}

	public void setAppExecParams(String appExecParams) {

		this.appExecParams = appExecParams;
	}

	public String getAppNotes() {

		return appNotes;
	}

	public void setAppNotes(String appNotes) {

		this.appNotes = appNotes;
	}

}
