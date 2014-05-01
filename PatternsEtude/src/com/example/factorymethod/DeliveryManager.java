package com.example.factorymethod;

import java.util.HashSet;
import java.util.Set;

import com.example.ProjectManager;

public class DeliveryManager extends ProjectManager {
	
	private Set<ManagmentPolicyCreator> projects = new HashSet<ManagmentPolicyCreator>();
	
	public void manageAccount() {
		for (ManagmentPolicyCreator project : projects) {
			ProjectPolicy policy = project.getPolicy("");
			policy.makePolicy();

		}
	}

}
