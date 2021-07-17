package com.example.demo.domain;

import com.example.demo.domain.pieces.*;

public class GasCar extends Car{
    //Se construye el coche de combustión invocado por
    // la FACADE de GasCar con los subsistemas configurados

    //1 Propiedades o atributos y configura coche eléctrico
    private OilTank oilTank;

    // Constructores

    public GasCar() {

    }

    public GasCar(Long id, Battery battery, AirConditioner airConditioner, Engine engine, OilTank oilTank, String brand, String color, Integer doors) {
        super(id, battery,airConditioner,engine, brand, color, doors);
        this.oilTank = oilTank;
    }
    //Setters y Getters de Subsistemas
    public OilTank getOilTank() {
        return oilTank;
    }

    public void setOilTank(OilTank oilTank) {
        this.oilTank = oilTank;
    }

    @Override
    public String toString() {
        return "GasCar{" +
                "oilTank=" + oilTank +
                '}';
    }
}
