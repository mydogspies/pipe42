package com.pipe42.console;

public class ConsoleOut {
	
	/**
	 * 
	 * @param any valid string as argument
	 */
	public static void printCons(String string) {
		System.out.println("PIPE42> " + string);
	}

	/**
	 * 
	 * @param prefix prefixes the output string below
	 * @param string any string as valid argument
	 */
	public static void printCons(String prefix, String string) {
		System.out.println(prefix + string);
	}
	
}
