package com.example.factorymethod;

public class FrodioPolicy extends ProjectPolicy {

	private String dependecyOne;
	
	public FrodioPolicy() {
		super();
	}
	
	public FrodioPolicy(String project, String dependencyOne) {
		this.dependecyOne = dependencyOne;
	}
	
	@Override
	public void makePolicy() {
		// TODO Auto-generated method stub

	}
}
