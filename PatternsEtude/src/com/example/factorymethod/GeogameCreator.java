package com.example.factorymethod;

public class GeogameCreator implements ManagmentPolicyCreator {

	@Override
	public ProjectPolicy getPolicy(String project) {
		return new GeogamePolicy(project, "dependencyOne", "dependencyTwo");
	}

}
