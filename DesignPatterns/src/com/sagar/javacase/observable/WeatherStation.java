package com.sagar.javacase.observable;

public class WeatherStation {

	public static void main(String[] args) {
		
		WeatherData weatherData = new WeatherData();

		CurrentConditionDisplay c = new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(84, 12, 20);
		
	}

}
