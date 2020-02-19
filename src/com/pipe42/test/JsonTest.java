package com.pipe42.test;

import java.util.ArrayList;
import java.util.List;

import com.pipe42.console.ConsoleOut;
import com.pipe42.data.Application;
import com.pipe42.data.JsonDataIO;

/**
 * NOTE!!!! The path for the json file is for testing purposes defined
 * in JsonData.java, at the top of the JsonData class. Pick the right
 * path before testing!!! 
 * 
 * Testing Jackson json functionality
 * @author Mydogspies
 *
 */
public class JsonTest {

	public static void main(String[] args) {

		// grab some data from our data objects and put it together
		InititateJSON data = new InititateJSON();
		List content = data.initiateJson();

		/* WRITE INTO FILE */

		// then do Jackson magic sending it off to our JsonData class
		JsonDataIO myData = new JsonDataIO();
		// myData.writeApplication(content);

		// say hello from main start method
		ConsoleOut.printCons("JsonTest finished");
		
	}

}
