package com.example.demo.domain;

import com.example.demo.domain.pieces.*;


public class ElectricCar extends Car{ //Concreción de la clase abstracta
    //Se construye el coche eléctrico invocado por
    // la FACADE de ElectricCar con los subsistemas configurados

    //1 Propiedades o atributos y configura coche eléctrico

    private ElectricPiece electricPiece;



    //2 Constructores
    public ElectricCar(){} //Constructor vacío

    //Constructor de la propiedad específica del vehículos y llamada a constructor (de la clase padre) de las propiedades comunes a todos los vehículos
    public ElectricCar(Long id, Battery battery, AirConditioner airConditioner, Engine engine, ElectricPiece electricPiece, String brand, String color) {
        super(id, battery,airConditioner,engine, brand, color);
        this.electricPiece = electricPiece;


    }
    //Setters y Getters de Subsistemas
    public ElectricPiece getElectricPiece() {
        return electricPiece;
    }

    public void setElectricPiece(ElectricPiece electricPiece) {
        this.electricPiece = electricPiece;
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "electricPiece=" + electricPiece +
                '}';
    }
}
