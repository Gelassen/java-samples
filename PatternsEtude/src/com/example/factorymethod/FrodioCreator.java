package com.example.factorymethod;

public class FrodioCreator implements ManagmentPolicyCreator {

	@Override
	public ProjectPolicy getPolicy(String project) {
		return new FrodioPolicy(project, "dependencyOne");
	}

}
