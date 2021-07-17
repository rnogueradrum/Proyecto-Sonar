
package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.GasCar;
import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.*;

//FACADE que configura los subsitemas comunes y particulares de los coches y devuelve un coche a la Expo
public class CarFacade extends Car {
	
    //Para todos los coches
    public static Car carReady(String carType) {

        //Configura lo común

        Battery battery = new Battery();
        battery.batteryOk();

        AirConditioner airConditioner = new AirConditioner();
        airConditioner.airOn();

        Engine engine = new Engine();
        engine.startedOn();

        //Llamada al método que configura lo particular de cada coche
        
        return CarFacade.expoCar(carType, battery, airConditioner, engine); //Devuelve a la expo el coche configurado

    }

    public static Car expoCar (String carType, Battery battery, AirConditioner airConditioner, Engine engine) { //configura cada particularidad de los coches y los construye

        final String ELECTRICAR = "ElectriCar";
        final String HYBRIDCAR = "HybridCar";
        final String GASCAR = "GasCar";
        
        Long id;
        String brand;
        String color;
        Integer doors;

        switch (carType) {
            case ELECTRICAR:
                //Configura particularidades del ELECTRICAR
                ElectricPiece electricPiece = new ElectricPiece();
                electricPiece.ok();
                id = 1L;
                brand = "Tesla";
                color = "Black";
                doors = 5;

                //Llama a la construcción del ELECTRICAR
                return new ElectricCar(id, battery, airConditioner, engine, electricPiece, brand, color, doors);

            case HYBRIDCAR:
                //Particularidad del HybridCar
                HybridPiece hybridPiece = new HybridPiece();
                hybridPiece.ok();
                id = 2L;
                brand = "Toyota";
                color = "Pearl White";
                doors = 5;

                //Llama a la construcción de HybridCar
                return new HybridCar(id, battery,airConditioner,engine,hybridPiece, brand, color, doors);

            case GASCAR:
                //Particularidad del coche de combustión
                OilTank oilTank = new OilTank();
                oilTank.fullTank();
                id = 3L;
                brand = "Honda";
                color = "Red";
                doors = 3;
                //Llama a la construcción de GasCar
                return new GasCar(id, battery, airConditioner, engine, oilTank, brand, color, doors);

            default: return null;//Por defecto devuelve un electricar. NO ES NECESARIO
        }
    }

    
}

