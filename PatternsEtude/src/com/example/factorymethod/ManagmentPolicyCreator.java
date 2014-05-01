package com.example.factorymethod;

public interface ManagmentPolicyCreator {

	public ProjectPolicy getPolicy(String project);
	
}
