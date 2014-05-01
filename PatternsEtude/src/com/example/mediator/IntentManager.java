package com.example.mediator;

public abstract class IntentManager {

	private Component sender;
	private Component recipient;
	
	public IntentManager(Component first, Component second) {
		this.sender = first;
		this.recipient = second;
	}
	
	public void sendMessage(String...args) {
		sender.sendMessage(args);
		recipient.receiveMessage(args);
	}
	
}
