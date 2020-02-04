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

	/* METHODS */
	
	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public String getPathToExecutable() {
		return pathToExecutable;
	}

	public String getExecParams() {
		return execParams;
	}

	public String getNotes() {
		return notes;
	}
	
}
