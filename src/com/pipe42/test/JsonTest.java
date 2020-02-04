package com.pipe42.test;

import java.util.ArrayList;

import com.pipe42.console.ConsoleOut;
import com.pipe42.data.JsonDataIO;
import com.pipe42.data.Project;

/**
 * Testing Jackson json functionality
 * @author Mydogspies
 *
 */
public class JsonTest {

	public static void main(String[] args) {
		
		// grab some data from our data objects and put it together
		AddTestData data = new AddTestData();
		
		/* WRITE INTO FILE */
		
		// then do Jackson magic sending it off to our JsonData class
		JsonDataIO myData = new JsonDataIO();
		myData.writeAllProjects(data.defineTestData());
		
		/* READ FROM FILE */
		ArrayList<Project> result = myData.getAllProjects();
		for (Project project : result) {
			ConsoleOut.printCons(project.getProjectName());
		}
		
		
		// say hello from main start method
		ConsoleOut.printCons("JsonTest finished");
		
	}

}