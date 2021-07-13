package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.NoValidCartype;

public class CarFactory { //Factory que pide coches de distinto tipo

    public static Car giveMeCar(String carType) throws NoValidCartype {

        if (!carType.equals("ElectriCar")
                && !carType.equals("HybridCar")
                && !carType.equals("GasCar"))  //Distinto de cualquiera de los 3.
            throw new NoValidCartype("********** 404 NOT FOUND: Wrong car type, try another one **********"); //Lanza excepción que captura el controlador

        return CarFacade.carReady(carType); //Llamada a la FACADE
    }
}
