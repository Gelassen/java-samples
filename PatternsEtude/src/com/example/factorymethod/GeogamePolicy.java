package com.example.factorymethod;

public class GeogamePolicy extends ProjectPolicy {

	private String dependecyOne;
	private String dependecyTwo;
	
	public GeogamePolicy() {
		super();
	}
	
	public GeogamePolicy(String project, String dependencyOne, String dependencyTwo) {
		this.dependecyOne = dependencyOne;
		this.dependecyTwo = dependencyTwo;
	}
	
	@Override
	public void makePolicy() {
		// TODO Auto-generated method stub

	}

}
