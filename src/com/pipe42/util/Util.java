package com.pipe42.util;

import com.pipe42.data.Hashids;

import java.net.URL;

public class Util {

	/**
	 * Takes a string as salt and returns a 6 character long hash code
	 * @param salt Any random string
	 * @return 6 character long has code as String
	 */
	public String getHash(String salt) {

		Hashids hashids = new Hashids(salt, 6, "0123456789abcdef");

		long random = (long) (Math.random() * 1000000);

		return hashids.encode(random).toString();
	}

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
