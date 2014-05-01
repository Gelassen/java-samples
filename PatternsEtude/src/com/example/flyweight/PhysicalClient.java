package com.example.flyweight;

public abstract class PhysicalClient implements Client {

	@Override
	public void calculateBill(int policy) {
		
	}
	
	protected abstract float sumCostsOfServices();

}
