package com.sagar.javacase.strategy;

public abstract class Duck {

	QuackBehavior quackable;
	FlyBehavior flyable;

	public abstract void display();

	public void setQuackBehavior(QuackBehavior qb) {
		this.quackable = qb;
	}

	public void setFlyBehavior(FlyBehavior fb) {
		this.flyable = fb;
	}

	public void performFly() {
		flyable.performFly();
	}

	public void performQuack() {
		quackable.performQuack();
	}

}
