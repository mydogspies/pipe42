package com.pipe42.data;

/**
 * The Application POJO
 * @author Mydogspies
 *
 */
public final class Application {
	
	private String appName;
	private String appVersion;
	private String pathToExecutable;
	private String execParams;
	private String notes;
	
	/* CONSTRUCTORS */
	
	public Application() {}

	public Application(String appName, String appVersion, String pathToExecutable, String execParams, String notes) {
		this.appName = appName;
		this.appVersion = appVersion;
		this.pathToExecutable = pathToExecutable;
		this.execParams = execParams;
		this.notes = notes;
	}

	/* GETTERS AND SETTERS */
	
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
