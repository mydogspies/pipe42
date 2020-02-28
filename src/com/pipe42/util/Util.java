package com.pipe42.util;

import com.pipe42.data.Hashids;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Util {

	/**
	 * Generates a HashMap with formatted day and time strings
	 * @return a HashMap with strings
	 */
	public static HashMap<String, String> getDateTime() {

		LocalDateTime dt = LocalDateTime.now();
		HashMap<String, String> dateData = new HashMap<>();
		dateData.put("date", dt.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
		dateData.put("time", dt.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));

		return dateData;
	}

	/**
	 * Takes a string as salt and returns a 6 character long hash code
	 * @param salt Any random string
	 * @return 6 character long has code as String
	 */
	public static String getHash(String salt) {

		Hashids hashids = new Hashids(salt, 6, "0123456789abcdef");

		long random = (long) (Math.random() * 1000000);

		return hashids.encode(random).toString();
	}

	/**
	 * Sanitize those paths
	 * @param path string with local absolute path
	 * @return string with system-specific path
	 */
	public static String getLocalURL(String path) {
			
			URL url = Util.class.getResource(path); // TODO not sure we will use this - review for every commit
			return url.toString();
			
		}
	
}
