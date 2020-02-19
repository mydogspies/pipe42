package com.pipe42.test;

import java.util.ArrayList;

import com.pipe42.data.Application;
import com.pipe42.data.Data;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;

public class AddTestData {
	
	public void defineTestData() {
	
	// Define two new entries
	Application testApp1 = new Application("1", "Maya", "2019", "c:/maya", "", "This is our main app");

	/*
	Owner testOwner2 = new Owner("0002", "Alex", "WzB", "office", "AM", "This is the Houdini main guy");
	Renderengine testEngine2 = new Renderengine("01", "Karma", "c:/houdini", "-h /.engine", "4.0.0", "This is our render engine within Houdini");
	Project testProject2 = new Project("0002", "MORESTUFF", "MSF", testOwner2, testEngine2, testApp2, "today", "today", "This is our project POJO");
	*/

	// Add it all together in a Data POJO
	
	}
	
}
