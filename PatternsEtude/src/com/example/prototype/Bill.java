package com.example.prototype;

public class Bill implements Cloneable {

	private String firstName;
	private String lastName;
	private String inn;
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Bill bill = new Bill();
		bill.firstName = this.firstName;
		bill.lastName = this.lastName;
		bill.inn = this.inn;
		return bill;
	}

	
	
}
