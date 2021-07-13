package com.example.demo.rest;

import org.springframework.stereotype.Component;

import com.example.demo.domain.NoValidCartype;
import com.example.demo.service.CarFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




@Path("/cars/{carType}") 
@Component
public class CarsController {
	
	
	/**
	 * Recibe como parámetro de URL un tipo de vehículo que pasará a una CarFactory
	 * y ésta a una CarFacade para su producción
	 * 
	 * http://localhost:8080/api/cars/GasCar
	 * http://localhost:8080/api/cars/ElectriCar
	 * http://localhost:8080/api/cars/HybridCar
	 * http://localhost:8080/api/cars/WrongCarType (NO EXISTE, DARÁ 404 NOT
	 * FOUND)
	 * 
	 * @param carType
	 * @return
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
        public Response findOne(@PathParam("carType") String carType) {

        try {

            return Response
            		.ok(CarFactory.giveMeCar(carType))
            		.build();
            
        } catch (NoValidCartype e) {
            e.printStackTrace();
            return Response
            		.status(Response.Status.NOT_FOUND)
            		.build();
        }

    }
}





