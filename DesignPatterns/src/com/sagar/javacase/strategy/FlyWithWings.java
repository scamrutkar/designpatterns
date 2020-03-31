package com.sagar.javacase.strategy;

public class FlyWithWings implements FlyBehavior{

	@Override
	public void performFly() {
		System.out.println("Flying with wings");
	}

}
