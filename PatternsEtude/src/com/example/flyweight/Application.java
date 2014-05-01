package com.example.flyweight;

public class Application {

	private static int userId = -1;
	
	public static void main(String...strings) {
		int policy = 1;
		// TODO choose policy
		
		ClientsFactory factory = new ClientsFactory();
		Client client = factory.getClientProcessor(userId);
		client.calculateBill(userId);
	}
	
}
