package com.pipe42.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pipe42.data.Application;
import com.pipe42.data.Data;
import com.pipe42.data.Hashids;
import com.pipe42.data.Owner;
import com.pipe42.data.Project;
import com.pipe42.data.Renderengine;
import com.pipe42.util.Util;

public class AddTestData {
	
	public static Data defineTestData() {

		// construct some datetime
		LocalDateTime modifyTime = LocalDateTime.now();
		LocalDateTime creationTime = LocalDateTime.now();

		// get some utils for hashing
		Util util = new Util();

		ArrayList<String> hash = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String hashnum = util.getHash("our project");
			hash.add(hashnum);
		}

		// add Applications
		Application app1 = new Application(hash.get(0), "Maya", "2019", "c:/autodesk/maya",
				"-f", "A Maya instance if Applciation");
		Application app2 = new Application(hash.get(1), "Davinci Resolve", "16.1", "c:/resolve",
				"-f -gg", "An instance of Davinci Resolve in Application");
		List<Application> applist = new ArrayList<Application>();
		applist.add(app1);
		applist.add(app2);

		// add Owner
		Owner owner1 = new Owner(hash.get(2), "Peter Mankowski", "WzB", "management", "PM", "An instance of Owner");
		List<Owner> ownerlist = new ArrayList<Owner>();
		ownerlist.add(owner1);

		// add Renderengine
		Renderengine eng1 = new Renderengine(hash.get(3), "Arnold", "c:/arnold",
				"-a", "3.2.1", "Arnold example of Renderengine");
		Renderengine eng2 = new Renderengine(hash.get(4), "Vray", "c:/vray",
				"-vr", "10", "Vray example of Renderengine");
		List<Renderengine> enginelist = new ArrayList<Renderengine>();
		enginelist.add(eng1);
		enginelist.add(eng2);

		// add projects
		Project proj1 = new Project(hash.get(5), "Test Project 1", "TS1",
				hash.get(2), hash.get(3), hash.get(0),
				creationTime, modifyTime, "Our first test project");
		Project proj2 = new Project(hash.get(6), "Test Project 2", "TS2",
				hash.get(2), hash.get(3), hash.get(1),
				creationTime, modifyTime, "Second test project");
		Project proj3 = new Project(hash.get(7), "Test Project 3", "TS3",
				hash.get(2), hash.get(4), hash.get(0),
				creationTime, modifyTime, "Third test project");
		List<Project> plist = new ArrayList<Project>();
		plist.add(proj1);
		plist.add(proj2);
		plist.add(proj3);

		// Add it all together in a Data POJO

		return new Data(plist, applist, ownerlist, enginelist);
	
	}
	
}
