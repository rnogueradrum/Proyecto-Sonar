package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.demo.domain.GasCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.OilTank;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GasCarServiceImplTest {
	
	
	GasCarServiceImpl gasCarServiceImpl; 
	

	@BeforeEach
	void setUp() throws Exception {
	gasCarServiceImpl = new GasCarServiceImpl() ;
	}

	
	@Order(1)
	@Test
	@DisplayName("GasCarServiceInstance")
	void GasCarServiceInstanceTest() {
		Integer elementos = gasCarServiceImpl.count();
		assertTrue(gasCarServiceImpl instanceof GasCarService);
		assertNotNull(elementos);
	}
	
	@Order(2)
	@Test
	@DisplayName("GasCarServiceCount")
	void countTest() {
		Integer elementos = gasCarServiceImpl.count();
		assertEquals(3, elementos);
		
		gasCarServiceImpl.delete(3L);		
		elementos = gasCarServiceImpl.count();
		assertEquals(2,elementos);
	}
	
	@Order(3)
	@Test
	@DisplayName("GasCarServiceFindAll")
	void findAllTest() {
		List<GasCar> gasCarList = gasCarServiceImpl.findAll();
		assertEquals(gasCarServiceImpl.count(), gasCarList.size());
	}
	
	@Order(4)
		@Test
		@DisplayName("GasCarServiceFindOne")
		void findOneTest() {
			GasCar gasCarFound = gasCarServiceImpl.findOne(1L);
			assertNotNull(gasCarFound);
			
		}
	
	@Order(5)
	@Test
	@DisplayName("GasCarServiceFindOneNull")
	void findOneNullTest() {
		GasCar gasCarFound = gasCarServiceImpl.findOne(null);
		assertNull(gasCarFound);
		gasCarFound = gasCarServiceImpl.findOne(10L);
		assertNull(gasCarFound);
		
	}
	
	
	@Order(6)
	@Test
	@DisplayName("GasCarServiceSaveUpdate")
	void saveUpdateTest() {
		GasCar gasCar4 = new GasCar(3L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new OilTank(),
				"Lexus",
				"Orange",
				8);
		gasCarServiceImpl.save(gasCar4);
				
		assertEquals("Lexus", gasCarServiceImpl.findOne(3L).getBrand());
	}
	
	@Order(7)
		@Test
		@DisplayName("GasCarServiceSaveCreateZeroId")
		void saveCreateZeroIdTest() {
			GasCar gasCar5 = new GasCar(0L, 
					new Battery(),
					new AirConditioner(),
					new Engine(),
					new OilTank(),
					"Fiat",
					"Grey",
					2);
			gasCarServiceImpl.save(gasCar5);
					
			assertEquals("Fiat", gasCarServiceImpl.findOne(4L).getBrand());
		
		}
		
		@Order(8)
		@Test
		@DisplayName("GasCarServiceSaveCreateNullId")
		void saveCreateNullIdTest() {	
			GasCar gasCar6 = new GasCar(null, 
					new Battery(),
					new AirConditioner(),
					new Engine(),
					new OilTank(),
					"Renault",
					"Silver",
					5);
			gasCarServiceImpl.save(gasCar6);
					
			assertEquals("Renault", gasCarServiceImpl.findOne(5L).getBrand());
		}
			
		
		@Order(9)
		@Test
		@DisplayName("GasCarServiceFindByColorFound")
			void findByColorFoundTest() {
					
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByColor("Red");
				assertEquals(false, gasCarFoundList.isEmpty());
				
			}
		
		
		@Order(10)
		@Test
		@DisplayName("GasCarServiceFindByColorNotFound")
			void findByColorNotFoundTest() {
			
			List<GasCar> gasCarFoundList = gasCarServiceImpl.findByColor("Black");
			assertEquals(true, gasCarFoundList.isEmpty());
		
		}
		
		
		@Order(11)
		@Test
		@DisplayName("GasCarServiceFindByColorNull")
			void findByColorNullTest() {
				
			List<GasCar> gasCarFoundList = gasCarServiceImpl.findByColor(null);
			assertNotNull(gasCarFoundList);
			
		}
		
		@Order(12)
		@Test
		@DisplayName("GasCarServiceFindByColorBlank")
			void findByColorBlankTest() {
					
			List<GasCar> gasCarFoundList = gasCarServiceImpl.findByColor("");
			assertNotNull(gasCarFoundList);
						
		}
		
		
		@Order(13)
		@Test
		@DisplayName("GasCarServiceFindByBrandFound")
			void findByBrandFoundTest() {
					
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByBrand("Honda");
				assertEquals(false, gasCarFoundList.isEmpty());
	}
		
		
		@Order(14)
		@Test
		@DisplayName("GasCarServiceFindByBrandNotFound")
			void findByBrandNotFoundTest() {
					
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByBrand("Seat");
				assertEquals(true, gasCarFoundList.isEmpty());
						
		}
		
		
		@Order(15)
		@Test
		@DisplayName("GasCarServiceFindByBrandNull")
			void findByBrandNullTest() {
							
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByBrand(null);
				assertNotNull(gasCarFoundList);
							
		}
			

		@Order(16)
		@Test
		@DisplayName("GasCarServiceFindByBrandBlank")
			void findByBrandBlankTest() {
			
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByBrand("");
				assertNotNull(gasCarFoundList);
							
		}
		

		@Order(17)
		@Test
		@DisplayName("GasCarServiceFindByDoorsFound")
			void findByDoorsFoundTest() {
							
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByDoors(3);
				assertEquals(false, gasCarFoundList.isEmpty());
									
		}
		
		@Order(18)
		@Test
		@DisplayName("GasCarServiceFindByDoorsNotFound")
			void findByDoorsNotFoundTest() {
							
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByDoors(12);
				assertEquals(true, gasCarFoundList.isEmpty());
									
		}
		
		@Order(19)
		@Test
		@DisplayName("GasCarServiceFindByDoorsNull")
			void findByDoorsNullTest() {
								
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByDoors(null);
				assertNotNull(gasCarFoundList);
									
		}
		
		@Order(20)
		@Test
		@DisplayName("GasCarServiceFindByDoorsNegative")
			void findByDoorsNegativeTest() {
								
				List<GasCar> gasCarFoundList = gasCarServiceImpl.findByDoors(-1);
				assertNotNull(gasCarFoundList);
									
		}
		
		
		@Order(21)
		@Test
		@DisplayName("GasCarServiceDeleteFound")
			void DeleteFoundTest() {
							
				Boolean deleted = gasCarServiceImpl.delete(5L);
				assertEquals(true, deleted);
				assertEquals(4, gasCarServiceImpl.count());			
		
		}
		
		@Order(22)
		@Test
		@DisplayName("GasCarServiceDeleteNull")
			void DeleteNULLTest() {
				
				Boolean deleted = gasCarServiceImpl.delete(null);
				assertEquals(false, deleted);
				assertEquals(4, gasCarServiceImpl.count());	
		}
		
		@Order(23)
		@Test
		@DisplayName("GasCarServiceDeleteNotFound")
			void DeleteNotFoundTest() {
				
				Boolean deleted = gasCarServiceImpl.delete(10L);
				assertEquals(false, deleted);
				assertEquals(4, gasCarServiceImpl.count());		
			
		}
		
		@Order(24)
		@Test
		@DisplayName("GasCarServiceDeleteNegative")
			void DeleteNegativeTest() {
							
				Boolean deleted = gasCarServiceImpl.delete(-3L);
				assertEquals(false, deleted);
				assertEquals(4, gasCarServiceImpl.count());		
		}
		
		@Order(25)
		@Test
		@DisplayName("GasCarServiceDeleteAll")
			void DeleteAllTest() {
					
				gasCarServiceImpl.deleteAll();;
				assertEquals(0, gasCarServiceImpl.count());			
		}
		
		@Order(26)
		@Test
		@DisplayName("GasCarServiceDeleteAllEmptyList")
			void DeleteAllEmptyListTest() {
					
				gasCarServiceImpl.deleteAll();;
				assertEquals(0, gasCarServiceImpl.count());			
		}
		
		@Order(27)
		@Test
		@DisplayName("GasCarServiceDeleteOneEmptyList")
			void DeleteOneEmptyListTest() {
				
				Boolean deleted = gasCarServiceImpl.delete(10L);
				assertEquals(0, gasCarServiceImpl.count());	
				assertEquals(false, deleted);
				assertEquals(0, gasCarServiceImpl.count());		
			
		}
		
		@Order(28)
		@Test
		@DisplayName("GasCarServiceSaveCreateFirstIdOnEmptyList")
		void saveCreateFirstIdOnEmptyListTest() {
			GasCar gasCarFirst = new GasCar(0L, 
					new Battery(),
					new AirConditioner(),
					new Engine(),
					new OilTank(),
					"Zero Car",
					"Red & White",
					2);
			gasCarServiceImpl.save(gasCarFirst);
					
			assertEquals("Zero Car", gasCarServiceImpl.findOne(1L).getBrand());
			assertEquals(1, gasCarServiceImpl.count());
		}


		

}
