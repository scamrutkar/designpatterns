package com.sagar.javacase.observable;

import java.util.ArrayList;

public class WeatherData implements Subject {
	
	private float temprature;
	private float humidity;
	private float pressure;
	private ArrayList<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i > 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(temprature, humidity, pressure);
		}
	}
	
	public void measurementChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temprature, float humidity, float pressure) {
		this.temprature = temprature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}

}
