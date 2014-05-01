package com.example.flyweight;

public abstract class CorporateClient implements Client{

	protected float cost = 0;
	
	private float multiplyer;

	public CorporateClient(float multiplyer) {
		this.multiplyer = multiplyer;
	}
	
	@Override
	public void calculateBill(int policy) {
		applySpecificPolicy(policy);
		cost *= multiplyer;
	}
	
	protected abstract void applySpecificPolicy (int policy);

	protected abstract float sumCostsOfServices();
}
