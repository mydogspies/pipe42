package com.pipe42.util;

import com.pipe42.data.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * This is the dreaded utility class where tiny things reside that did not find space anywhere else.
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class Util {

	private static final Logger log = LoggerFactory.getLogger(Util.class);

	/**
	 * Generates a HashMap with formatted day and time strings
	 * @return a map with date and time
	 */
	public static HashMap<String, String> getDateTime() {

		LocalDateTime dt = LocalDateTime.now();
		HashMap<String, String> dateData = new HashMap<>();
		dateData.put("date", dt.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
		dateData.put("time", dt.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));

		log.debug("getDateTime(): Returned a date&time map: " +  dateData);

		return dateData;
	}

	/**
	 * Takes a string as salt and returns a 6 character long hash code
	 * @param salt Any random string
	 * @return hash code
	 */
	public static String getHash(String salt) {

		Hashids hashids = new Hashids(salt, 6, "0123456789abcdef");
		long random = (long) (Math.random() * 1000000);
		String hashCode = hashids.encode(random);

		log.debug("getHash(): Returned a hash string: " + hashCode);

		return hashCode;
	}
	
}
