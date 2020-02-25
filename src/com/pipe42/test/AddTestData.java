package com.pipe42.test;

import java.util.ArrayList;
import java.util.List;

import com.pipe42.data.Application;
import com.pipe42.data.Data;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;

public class AddTestData {
	
	public static Data defineTestData() {

		// add Applications
		Application app1 = new Application("1", "Maya", "2019", "c:/autodesk/maya",
				"-f", "A Maya instance if Applciation");
		Application app2 = new Application("2", "Davinci Resolve", "16.1", "c:/resolve",
				"-f -gg", "An instance of Davinci Resolve in Application");
		List<Application> applist = new ArrayList<Application>();
		applist.add(app1);
		applist.add(app2);

		// add Owner
		Owner owner1 = new Owner("1", "Peter Mankowski", "WzB", "management", "PM", "An instance of Owner");
		List<Owner> ownerlist = new ArrayList<Owner>();
		ownerlist.add(owner1);

		// add Renderengine
		Renderengine eng1 = new Renderengine("1", "Arnold", "c:/arnold",
				"-a", "3.2.1", "Arnold example of Renderengine");
		Renderengine eng2 = new Renderengine("2", "Vray", "c:/vray",
				"-vr", "10", "Vray example of Renderengine");
		List<Renderengine> enginelist = new ArrayList<Renderengine>();
		enginelist.add(eng1);
		enginelist.add(eng2);

		// add projects
		Project proj1 = new Project("1", "Test Project 1", "TS1",
				"1", "1", "1",
				"1209378", "239847", "Our first test project");
		Project proj2 = new Project("2", "Test Project 2", "TS2",
				"1", "1", "2",
				"1209378", "239847", "Second test project");
		Project proj3 = new Project("3", "Test Project 3", "TS3",
				"1", "2", "2",
				"1209378", "239847", "Third test project");
		List<Project> plist = new ArrayList<Project>();
		plist.add(proj1);
		plist.add(proj2);
		plist.add(proj3);

		// Add it all together in a Data POJO

		return new Data(plist, applist, ownerlist, enginelist);
	
	}
	
}
