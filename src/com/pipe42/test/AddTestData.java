package com.pipe42.test;

import com.pipe42.data.Application;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;

public class AddTestData {
	
	// Define two new entries
	Application testApp1 = new Application("Maya", "2019", "c:/maya", "", "This is our main app");
	Owner testOwner1 = new Owner("Peter", "WzB", "office", "PM", "This is our project owner");
	Renderengine testEngine1 = new Renderengine("Arnold", "c:/arnold", "-b -D -aa", "3.2.0", "This is our render engine");
	Project testProject1 = new Project("0001", "PROJECT_ONE", "PON", testOwner1, testEngine1, testApp1, "today", "today", "This is our project POJO");
			
	Application testApp2 = new Application("Houdini", "18.5", "c:/houdini", "", "This is Houdini");
	Owner testOwner2 = new Owner("Alex", "WzB", "office", "AM", "This is the Houdini main guy");
	Renderengine testEngine2 = new Renderengine("Karma", "c:/houdini", "-h /.engine", "4.0.0", "This is our render engine within Houdini");
	Project testProject2 = new Project("0001", "MORESTUFF", "MSF", testOwner2, testEngine2, testApp2, "today", "today", "This is our project POJO");
		

}
