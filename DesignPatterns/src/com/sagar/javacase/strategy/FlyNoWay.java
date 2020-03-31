package com.sagar.javacase.strategy;

public class FlyNoWay implements FlyBehavior{

	@Override
	public void performFly() {
		System.out.println("Fly no way....!!!");
	}

}
