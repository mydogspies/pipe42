package com.pipe42.main;

import com.pipe42.gui.MainWindow;


/**
 * Default startup method for PIPE42
 * @author Mydogspies
 * @version 0.1pre
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// TODO - Main - Build a pre-loader

		// initialize stuff
		Initialize.setObjectMapper();
		
		// open main GUI window
		MainWindow.main(args);

	}

}
