package com.example.decorator;

import com.example.Developer;
import com.example.SoftwareDeveloper;

public class Decorator extends SoftwareDeveloper{

	private Developer developer;
	
	// pass a child of developer, e.g. TeamLead
	public Decorator(Developer developer) {
		this.developer = developer;
	}
	

	@Override
	public void writeCode() {
		// before code we need a meeting
		speach();
		developer.writeCode();
		// after code we need another meeting
		speach();
	}


	public void speach() {
		System.out.println("Start speach");
	}
	
}
