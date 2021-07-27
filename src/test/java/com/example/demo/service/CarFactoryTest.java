package com.example.demo.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import com.example.demo.domain.GasCar;
import com.example.demo.domain.HybridCar;
import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.NoValidCartype;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarFactoryTest {

	GasCar gasCarDummy = new GasCar();
	ElectricCar electricCarDummy = new ElectricCar();
	HybridCar hybridCarDummy = new HybridCar();
	
	@Order(1)
	@Test
	@DisplayName("CarFactoryInstance")
	void CarFactoryInstanceTest() {
		CarFactory instanceCarFactory = new CarFactory();
		assertTrue(instanceCarFactory instanceof CarFactory);
	}
	
	@Order(2)
	@Test
	@DisplayName("gasCarTypeExist")
	void gasCarTypeExistTest() throws NoValidCartype {
		gasCarDummy = (GasCar) CarFactory.giveMeCar("GasCar");
		assertNotNull(gasCarDummy);
	}
	
	
	@Order(4)
	@Test
	@DisplayName("electricCarTypeExist")
	void electricCarTypeExistTest() throws NoValidCartype {
		electricCarDummy = (ElectricCar) CarFactory.giveMeCar("ElectriCar");
		assertNotNull(electricCarDummy);
	}
	
	
	@Order(6)
	@Test
	@DisplayName("hybridCarTypeExist")
	void hybridCarTypeExistTest() throws NoValidCartype {
		hybridCarDummy = (HybridCar) CarFactory.giveMeCar("HybridCar");
		assertNotNull(hybridCarDummy);
		
	}
	
	
	@Order(8)
	@Test
	@DisplayName("carTypeError")
	void carTypeErrorTest() throws NoValidCartype {
		Exception exception = assertThrows(
				NoValidCartype.class, 
				() -> CarFactory.giveMeCar("WrongCarType")
				);
		
		String message = "********** 404 NOT FOUND: Wrong car type, try another one **********";		
		assertEquals(message, exception.getMessage());
	}
	

}
