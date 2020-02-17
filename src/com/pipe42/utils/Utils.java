package com.pipe42.utils;

import java.net.URL;

public class Utils {
	
	/**
	 * Sanitize those paths
	 * @param path string with local absolute path
	 * @return string with system-specific path
	 */
	public String getLocalURL(String path) {
			
			URL url = this.getClass().getResource(path);
			return url.toString();
			
		}
	
}
