package com.pipe42.console;

// TODO we may end up not using this at all in favor of logback - review every major commit

/**
 * A set of methods to format string for outputting to console.
 * @author Peter Mankowski
 * @since 0.1.0
 */
public class ConsoleOut {
	
	/**
	 * Takes a string and formats it to output to console. This method simply uses the println in Java with some
	 * additional formatting.
	 * @param string input of type String
	 */
	public static void printCons(String string) {
		System.out.println("PIPE42> " + string);
	}

}
