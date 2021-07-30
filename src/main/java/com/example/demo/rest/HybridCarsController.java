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


import com.example.demo.domain.HybridCar;
import com.example.demo.service.HybridCarService;


@Path("/hybridcar")
@Component
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class HybridCarsController {
	
		private HybridCarService hybridCarService;

		public HybridCarsController(HybridCarService hybridCarService) {
			this.hybridCarService = hybridCarService;
		}
		
		/**
		 * GET http://localhost:8080/api/hybridcar
		 */
	    @GET
	    public List<HybridCar> findAll(){
	        return hybridCarService.findAll();
	    }

	    /**
	     * GET
	     * http://localhost:8080/api/hybridcar/1
	     * http://localhost:8080/api/hybridcar/2
	     * http://localhost:8080/api/hybridcar/3
	     * http://localhost:8080/api/hybridcar/4
	     */
	    @GET
	    @Path("{id}")
	    public Response findOne(@PathParam("id") Long id){
	    	HybridCar hybridCar = hybridCarService.findOne(id);
	        if (hybridCar == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(hybridCar).build();
	    }

	    /**
	     * POST http://localhost:8080/api/hybridcar
	     */
	    @POST // CREAR NUEVO
	    public Response create(HybridCar hybridCar){
	        
	        if (hybridCar.getId() == null || hybridCar.getId() == 0)  {
	        	HybridCar result = hybridCarService.save(hybridCar);
	        	return Response.ok(result).build();
	        }
	         
	        return Response.status(Response.Status.BAD_REQUEST).build();
	    }

	    /**
	     * PUT http://localhost:8080/api/hybridcar
	     */
	    @PUT // ACTUALIZAR
	    public Response update(HybridCar hybridCar){
	        if (hybridCar.getId() == null || hybridCar.getId() == 0) 
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        
	        HybridCar result = hybridCarService.save(hybridCar);
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
	        if(!hybridCarService.delete(id))
	        	return Response.status(Response.Status.NOT_FOUND).build();
	        
	        return Response.ok(Response.Status.OK).build();
	    }

	    /**
	     * DELETE
	     * http://localhost:8080/api/hybridcar
	     */
	    @DELETE
	    public Response deleteAll(){
	    	hybridCarService.deleteAll();
	        return Response.ok(Response.Status.OK).build();
	    }
	    
	    /**
	     * Filtro findByColor
	     * GET
	     * http://localhost:8080/api/hybridcar/color/Yellow
	     */
	    @GET
	    @Path("color/{color}")
	    public Response findByColor(@PathParam("color") String color){

	    	List<HybridCar> byColor = hybridCarService.findByColor(color);
	        if (byColor == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(byColor).build();
	    }

	   
	    /**
	     * Filtro findByBrand
	     * GET
	     * http://localhost:8080/api/hybridcar/brand/Honda
	     */
	    @GET
	    @Path("brand/{brand}")
	    public Response findByBrand(@PathParam("brand") String brand){
	    	List<HybridCar> byBrand = hybridCarService.findByBrand(brand);
	        if (byBrand == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(byBrand).build();
	    }
	    
	    /**
	     * Filtro findByDoors
	     * GET
	     * http://localhost:8080/api/hybridcar/doors/3
	     */
	    @GET
	    @Path("doors/{doors}")
	    public Response findByDoors(@PathParam("doors") Integer doors){
	    	List<HybridCar> byDoors = hybridCarService.findByDoors(doors);
	        if (byDoors == null)
	            return Response.status(Response.Status.NOT_FOUND).build();

	        return Response.ok(byDoors).build();
	    }
		




}
