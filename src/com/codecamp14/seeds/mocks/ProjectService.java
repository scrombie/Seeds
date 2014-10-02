package com.codecamp14.seeds.mocks;

import java.util.ArrayList;
import java.util.List;
import com.codecamp14.seeds.models.*;

public class ProjectService {
	private static List<Project> projects = new ArrayList<Project>();
	
//	static {
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//		projects.add(new Project("No cause for alarm!", "Alarm description", "Alarm article"));
//	}
	
	public List<Project> getProjects() {
		return projects;
	}
}
