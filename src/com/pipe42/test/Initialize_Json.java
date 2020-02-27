package com.pipe42.test;

import com.pipe42.console.ConsoleOut;
import com.pipe42.data.Data;
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
public class Initialize_Json {

	public static void main(String[] args) {



		// initiate a json db with some data
		Data data = AddTestData.defineTestData();

		// call json writer
		JsonDataIO io = new JsonDataIO();
		io.writeJsonData(data);

		// say hello from main start method
		ConsoleOut.printCons("Initialize_Json finished");
		
	}

}
