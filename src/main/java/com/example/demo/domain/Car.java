package com.example.demo.domain;

import com.example.demo.domain.pieces.*;

public abstract class Car {

    private Long id;
    private String brand;
    private String color;
    
	private Battery battery;
    private AirConditioner airConditioner;
    private Engine engine;
    



    //Constructor vacío
    protected Car() {}

    //Constructor de las propiedades comunes a todos los vehículos
    protected Car(Long id, Battery battery, AirConditioner airConditioner, Engine engine, String brand, String color) {
        this.id = id;
    	this.battery = battery;
        this.airConditioner = airConditioner;
        this.engine = engine;
        this.brand = brand;
        this.color = color;
    }

    //Setters y Getters de Subsistemas comunes
        
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public AirConditioner getAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", color=" + color + ", battery=" + battery + ", airConditioner="
				+ airConditioner + ", engine=" + engine + "]";
	}

	
	
}

