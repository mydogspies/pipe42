package test;

import org.python.util.PythonInterpreter;


/**
 * General startup test
 * @author Mydogspies
 *
 */
public class PythonTest {
	
	private static PythonInterpreter pyInterp;

	public static void main(String[] args) {
		
		// fix for the pesky UnsupportedCharsetException message
		System.setProperty("python.console.encoding", "UTF-8");
		// and preload a Jython interpreter
		pyInterp = new PythonInterpreter();

		
		// say hello from default main start method
		System.out.println("PythonTest says hello");
		
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
			System.out.println("Jython error");
			e.printStackTrace();
		}
			
	}

}
