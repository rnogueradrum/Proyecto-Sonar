package com.example.demo.domain;

import com.example.demo.domain.pieces.*;

public class HybridCar extends Car{
    //Se construye el coche híbrido invocado por
    // la FACADE de HybridCar con los subsistemas configurados

    //1 Propiedades o atributos y configura coche híbrido
    private HybridPiece hybridPiece;

    //2 Constructores
    public HybridCar() {}//Constructor vacío

    public HybridCar(Long id, Battery battery, AirConditioner airConditioner, Engine engine, HybridPiece hybridPiece, String brand, String color, Integer doors) {
        super(id, battery,airConditioner,engine, brand, color, doors);
        this.hybridPiece = hybridPiece;
       
    }
    //Setters y Getters de Subsistemas
    public HybridPiece getHybridPiece() {
        return hybridPiece;
    }

    public void setHybridPiece(HybridPiece hybridPiece) {
        this.hybridPiece = hybridPiece;
    }

    @Override
    public String toString() {
        return "HybridCar{" +
                "hybridPiece=" + hybridPiece +
                '}';
    }
}
