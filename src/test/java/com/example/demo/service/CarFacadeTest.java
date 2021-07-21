package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.GasCar;
import com.example.demo.domain.HybridCar;
import com.example.demo.domain.NoValidCartype;

class CarFacadeTest {
	
	GasCar gasCarDummy = new GasCar();
	ElectricCar electricCarDummy = new ElectricCar();
	HybridCar hybridCarDummy = new HybridCar();
	ElectricCar impossibleCarDummy = new ElectricCar();

	@Order(1)
	@Test
	@DisplayName("CarFacadeInstance")
	void CarFacadeInstanceTest() {
		CarFacade instanceCarFacade = new CarFacade();
		assertTrue(instanceCarFacade instanceof CarFacade);
	}
	
	@Order(3)
	@Test
	@DisplayName("gasCarOK")
	void gasCarOKTest() throws NoValidCartype {
		gasCarDummy = (GasCar) CarFacade.carReady("GasCar");
		
		assertEquals(true ,gasCarDummy.getAirConditioner().getAirSwitch());
		assertEquals(true ,gasCarDummy.getBattery().getCharged());
		assertEquals(true ,gasCarDummy.getEngine().getIgnition());
		assertEquals(true ,gasCarDummy.getOilTank().getOilTank());
		
	}
	
	@Order(5)
	@Test
	@DisplayName("electricCarOK")
	void electricCarOKTest() throws NoValidCartype {
		electricCarDummy = (ElectricCar) CarFacade.carReady("ElectriCar");
		
		assertEquals(true ,electricCarDummy.getAirConditioner().getAirSwitch());
		assertEquals(true ,electricCarDummy.getBattery().getCharged());
		assertEquals(true ,electricCarDummy.getEngine().getIgnition());
		assertEquals(true ,electricCarDummy.getElectricPiece().getElectricPieceCheck());
		
	}
	
	@Order(7)
	@Test
	@DisplayName("hybridCarOK")
	void hybridCarOKTest() throws NoValidCartype {
		hybridCarDummy = (HybridCar) CarFacade.carReady("HybridCar");
		
		assertEquals(true ,hybridCarDummy.getAirConditioner().getAirSwitch());
		assertEquals(true ,hybridCarDummy.getBattery().getCharged());
		assertEquals(true ,hybridCarDummy.getEngine().getIgnition());
		assertEquals(true ,hybridCarDummy.getHybridPiece().getHybridPieceCheck());
		
	}
	
	
	@Order(9)
	@Test
	@DisplayName("ImpossibleCar")
	void ImpossibleCarTest() throws NoValidCartype {
		impossibleCarDummy = (ElectricCar) CarFacade.carReady("ImpossibleCar");
		
		assertNull(impossibleCarDummy);
		
	}
	
	

}
