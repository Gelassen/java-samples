package com.example.prototype;

public class DataArtBill extends Bill {

	private String specificAccount;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		DataArtBill bill = (DataArtBill) super.clone();
		bill.specificAccount = this.specificAccount;
		return bill;
	}
	
	

}
