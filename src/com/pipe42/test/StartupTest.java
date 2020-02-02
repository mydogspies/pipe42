package com.pipe42.test;

import org.python.util.PythonInterpreter;
import com.pipe42.gui.WindowMain;
import com.pipe42.console.ConsoleOut;

public class StartupTest {
	
	private static PythonInterpreter pyInterp;

	public static void main(String[] args) {
		
		// fix for the pesky UnsupportedCharsetException message
		System.setProperty("python.console.encoding", "UTF-8");
		// and pre-load a Jython interpreter
		pyInterp = new PythonInterpreter();
		
		// say hello from default main start method
		ConsoleOut.printCons("PIPE42: ","Hello from main!");
		
		// test a main window call
		WindowMain.main(args);
		
		// test Jython
		testPy();
		      
	}
	
	/**
	 * Quick test if Jython is connected
	 */
	private static void testPy() {
		 	
			pyInterp.exec("print('Hello from Jython!')");
			pyInterp.close();
	}

}
