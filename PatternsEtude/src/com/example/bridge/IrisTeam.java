package com.example.bridge;

import com.example.Manager;

public class IrisTeam extends Team {

	public IrisTeam(Manager manager) {
		super(manager);
	}

	@Override
	public void doWork() {
		makeEstimate();
		codeReview();
	}
	
	public void makeEstimate() {
		
	}
	
	public void codeReview() {
		
	}

}
