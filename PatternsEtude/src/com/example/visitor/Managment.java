package com.example.visitor;

import com.example.SoftwareDeveloper;
import com.example.TeamLead;
import com.example.factorymethod.DeliveryManager;

public interface Managment {

	public void manageTeamLead(TeamLead developer);
	public void maangeDeveloper(SoftwareDeveloper developer);
	public void report(DeliveryManager managment);
	
}
