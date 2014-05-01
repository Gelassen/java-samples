package com.example.builder;

public class Builder {
	
	private Bill bill;
	
	public Builder() {
		this.bill = new Bill();
	}
	
	public Builder buildName() {
		bill.buildName();
		return this;
	}
	
	public Builder buildAccount() {
		bill.buildAccount();
		return this;
	}
	

}
