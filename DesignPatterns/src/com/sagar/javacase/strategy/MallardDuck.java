package com.sagar.javacase.strategy;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	@Override
	public void display() {
		System.out.println("Display Mallard Duck");

	}
	
	public static void main(String[] args) {
		MallardDuck md = new MallardDuck();
		md.performFly();
		md.performQuack();
		md.display();
	}

}
