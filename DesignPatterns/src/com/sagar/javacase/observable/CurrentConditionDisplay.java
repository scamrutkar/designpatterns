package com.sagar.javacase.observable;

public class CurrentConditionDisplay implements Observer, DisplayElement{

	private float temprature;
	private float humidity;
	private float pressure;
	@SuppressWarnings("unused")
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("The current condition display weather is Temprature = "
					+this.temprature+" Humidity = "+this.humidity+" Pressure = "+this.pressure);
		
	}

	@Override
	public void update(float temprature, float humidity, float pressure) {
		this.temprature = temprature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
