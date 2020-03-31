package com.sagar.javacase.strategy;

public class Quack implements QuackBehavior {

	@Override
	public void performQuack() {
		System.out.println("Quack");

	}

}
