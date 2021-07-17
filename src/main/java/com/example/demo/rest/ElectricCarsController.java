package com.example.demo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.GasCar;
import com.example.demo.service.ElectricCarService;
import com.example.demo.service.GasCarService;

	@Path("/electriccar")
	@Component
	@Produces(MediaType.APPLICATION_JSON) 
	@Consumes(MediaType.APPLICATION_JSON) 
	public class ElectricCarsController {

		private ElectricCarService electricCarService;

		public ElectricCarsController(ElectricCarService electricCarService) {
			this.electricCarService = electricCarService;
		}
		
		/**
		 * GET http://localhost:8080/api/electriccar
		 */
	    @GET
	    public List<ElectricCar> findAll(){
	        return electricCarService.findAll();
	    }

	    /**
	     * GET
	     * http://localhost:8080/api/electriccar/1
	     * http://localhost:8080/api/electriccar/2
	     * http://localhost:8080/api/electriccar/3
	     * http://localhost:8080/api/electriccar/4
	     */
	    @GET
	    @Path("{id}")
	    public Response findOne(@PathParam("id") Long id){
	    	ElectricCar electricCar = electricCarService.findOne(id);
	        if (electricCar == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(electricCar).build();
	    }

	    /**
	     * POST http://localhost:8080/api/electriccar
	     */
	    @POST // CREAR NUEVO
	    public Response create(ElectricCar electricCar){
	        
	        if (electricCar.getId() == null || electricCar.getId() == 0)  {
	        	ElectricCar result = electricCarService.save(electricCar);
	        	return Response.ok(result).build();
	        }
	         
	        return Response.status(Response.Status.BAD_REQUEST).build();
	    }

	    /**
	     * PUT http://localhost:8080/api/electriccar
	     */
	    @PUT // ACTUALIZAR
	    public Response update(ElectricCar electricCar){
	        if (electricCar.getId() == null || electricCar.getId() == 0) 
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        
	        ElectricCar result = electricCarService.save(electricCar);
	        return Response.ok(result).build();
	    }


	    /**
	     * DELETE
	     * http://localhost:8080/api/electriccar/1
	     * http://localhost:8080/api/electriccar/2
	     */
	    @DELETE
	    @Path("{id}")
	    public Response deleteOne(@PathParam("id") Long id){
	        if(!electricCarService.delete(id))
	        	return Response.status(Response.Status.NOT_FOUND).build();
	        
	        return Response.ok(Response.Status.OK).build();
	    }

	    /**
	     * DELETE
	     * http://localhost:8080/api/electriccar
	     */
	    @DELETE
	    public Response deleteAll(){
	    	electricCarService.deleteAll();
	        return Response.ok(Response.Status.OK).build();
	    }
	    
	    /**
	     * Filtro findByColor
	     * GET
	     * http://localhost:8080/api/electriccar/color/Yellow
	     */
	    @GET
	    @Path("color/{color}")
	    public Response findByColor(@PathParam("color") String color){

	    	List<ElectricCar> byColor = electricCarService.findByColor(color);
	        if (byColor == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(byColor).build();
	    }

	   
	    /**
	     * Filtro findByBrand
	     * GET
	     * http://localhost:8080/api/electriccar/brand/Honda
	     */
	    @GET
	    @Path("brand/{brand}")
	    public Response findByBrand(@PathParam("brand") String brand){
	    	List<ElectricCar> byBrand = electricCarService.findByBrand(brand);
	        if (byBrand == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(byBrand).build();
	    }
	    
	    /**
	     * Filtro findByDoors
	     * GET
	     * http://localhost:8080/api/electriccar/doors/3
	     */
	    @GET
	    @Path("doors/{doors}")
	    public Response findByDoors(@PathParam("doors") Integer doors){
	    	List<ElectricCar> byDoors = electricCarService.findByDoors(doors);
	        if (byDoors == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(byDoors).build();
	    }
		

}
