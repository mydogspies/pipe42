package com.pipe42.test;

import org.python.util.PythonInterpreter;
import com.pipe42.gui.MainWindow;
import com.pipe42.console.ConsoleOut;


/**
 * General startup test
 * @author Mydogspies
 *
 */
public class StartupTest {
	
	private static PythonInterpreter pyInterp;

	public static void main(String[] args) {
		
		// fix for the pesky UnsupportedCharsetException message
		System.setProperty("python.console.encoding", "UTF-8");
		// and preload a Jython interpreter
		pyInterp = new PythonInterpreter();

		
		// say hello from default main start method
		ConsoleOut.printCons("StartupTest says hello");
		
		// test a main window call
		MainWindow.main(args);
		
		// test Jython
		testPy();
		      
	}
	
	/**
	 * Quick test if Jython is connected
	 */
	private static void testPy() {
		 	
		try {
			pyInterp.exec("print('Hello from Jython!')");
			pyInterp.close();
		} catch(Exception e) {
			ConsoleOut.printCons("Jython error");
			e.printStackTrace();
		}
			
	}

}
