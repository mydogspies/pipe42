package com.pipe42.test;

import java.time.LocalDateTime;

import com.pipe42.console.ConsoleOut;
import com.pipe42.data.Application;
import com.pipe42.data.JsonData;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;


/**
 * Testing Jackson json functionality
 * @author Mydogspies
 *
 */
public class JsonTest {

	public static void main(String[] args) {
		
		// grab some data from our data objects
		AddTestData data = new AddTestData();
		
		/* WRITE INTO FILE */
		
		// then do Jackson magic sending it off to our JsonData class
		JsonData myData = new JsonData();
		myData.writeEntry(data.testProject1, "append");
		
		/* READ FROM FILE */
		Project getProject = myData.listAllEntries();
		ConsoleOut.printCons(getProject.getProjectName());
		
		// say hello from main start method
		ConsoleOut.printCons("JsonTest finished");
		
	}

}
