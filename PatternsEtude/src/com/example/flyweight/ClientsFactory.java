package com.example.flyweight;

import java.util.HashMap;

public class ClientsFactory {

	private HashMap<Integer, Client> clients = new HashMap<>();
	
	public Client getClientProcessor(int code) {
		Client client = clients.get(code);
		if (client == null) {
			client = createNewClient(code);
			clients.put(code, client);
		}
		return client;
	}
	
	private Client createNewClient(int code) {
		// TODO get client by code 		
		return new DataArtEmployee();
	}
}
