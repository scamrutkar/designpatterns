package com.sagar.javacase.strategy;

public class MuteQuack implements QuackBehavior {

	@Override
	public void performQuack() {
		System.out.println("<< Silence Quack >>");
	}

}
