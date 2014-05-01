package com.example.bridge;

import com.example.Manager;

public abstract class Team {

	private Manager manager;
	
	public Team(Manager manager) {
		this.manager = manager;
	}
	
	public abstract void doWork();
}
