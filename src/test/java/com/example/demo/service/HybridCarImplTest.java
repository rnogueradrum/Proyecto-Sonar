package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.HybridPiece;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HybridCarImplTest {
	
	HybridCarImpl hybridCarImpl; 
	
	@BeforeEach
	void setUp() throws Exception {
		hybridCarImpl = new HybridCarImpl() ;
		}
	
	@Order(1)
	@Test
	@DisplayName("HybridCarImplInstance")
	void HybridCarImplInstanceTest() {
		Integer elementos = hybridCarImpl.count();
		assertTrue(hybridCarImpl instanceof HybridCarImpl);
		assertNotNull(elementos);
	}
	
	@Order(2)
	@Test
	@DisplayName("HybridCarImplCount")
	void countTest() {
		Integer elementos = hybridCarImpl.count();
		assertEquals(3, elementos);
		
		hybridCarImpl.delete(3L);		
		elementos = hybridCarImpl.count();
		assertEquals(2,elementos);
	}
	
	@Order(3)
	@Test
	@DisplayName("hybridCarImplFindAll")
	void findAllTest() {
		List<HybridCar> hybridCarList = hybridCarImpl.findAll();
		assertEquals(hybridCarImpl.count(), hybridCarList.size());
	}
	
	@Order(4)
		@Test
		@DisplayName("hybridCarImplFindOne")
		void findOneTest() {
			HybridCar hybridCarFound = hybridCarImpl.findOne(1L);
			assertNotNull(hybridCarFound);
			
		}
	
	@Order(5)
	@Test
	@DisplayName("hybridCarImplFindOneNull")
	void findOneNullTest() {
		HybridCar hybridCarFound = hybridCarImpl.findOne(null);
		assertNull(hybridCarFound);
		hybridCarFound = hybridCarImpl.findOne(10L);
		assertNull(hybridCarFound);
		
	}
	
	
	@Order(6)
	@Test
	@DisplayName("hybridCarImplSaveUpdate")
	void saveUpdateTest() {
		HybridCar hybridCar4 = new HybridCar(3L,
    			new Battery(),
				new AirConditioner(),
				new Engine(),
				new HybridPiece(),
				"BMW",
				"Deep Blue",
				3);
		hybridCarImpl.save(hybridCar4);
				
		assertEquals("BMW", hybridCarImpl.findOne(3L).getBrand());
	}
	
	@Order(7)
		@Test
		@DisplayName("HybridCarServiceSaveCreateZeroId")
		void saveCreateZeroIdTest() {
		HybridCar hybridCar5 = new HybridCar(0L,
    			new Battery(),
				new AirConditioner(),
				new Engine(),
				new HybridPiece(),
				"Fiat",
				"Grey",
				2);
		hybridCarImpl.save(hybridCar5);
					
			assertEquals("Fiat", hybridCarImpl.findOne(4L).getBrand());
		
		}
		
		@Order(8)
		@Test
		@DisplayName("HybridCarServiceSaveCreateNullId")
		void saveCreateNullIdTest() {	
			HybridCar hybridCar6 = new HybridCar(null,
	    			new Battery(),
					new AirConditioner(),
					new Engine(),
					new HybridPiece(),
					"Renault",
					"Silver",
					5);
			hybridCarImpl.save(hybridCar6);
					
			assertEquals("Renault", hybridCarImpl.findOne(5L).getBrand());
		}
			
		
		@Order(9)
		@Test
		@DisplayName("HybridCarServiceFindByColorFound")
			void findByColorFoundTest() {
					
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByColor("White");
				assertEquals(false, hybridCarFoundList.isEmpty());
				
			}
		
		
		@Order(10)
		@Test
		@DisplayName("HybridCarServiceFindByColorNotFound")
			void findByColorNotFoundTest() {
			
			List<HybridCar> hybridCarFoundList = hybridCarImpl.findByColor("Black");
			assertEquals(true, hybridCarFoundList.isEmpty());
		
		}
		
		
		@Order(11)
		@Test
		@DisplayName("HybridCarServiceFindByColorNull")
			void findByColorNullTest() {
				
			List<HybridCar> hybridCarFoundList = hybridCarImpl.findByColor(null);
			assertNotNull(hybridCarFoundList);
			
		}
		
		@Order(12)
		@Test
		@DisplayName("HybridCarServiceFindByColorBlank")
			void findByColorBlankTest() {
					
			List<HybridCar> hybridCarFoundList = hybridCarImpl.findByColor("");
			assertNotNull(hybridCarFoundList);
						
		}
		
		
		@Order(13)
		@Test
		@DisplayName("HybridCarServiceFindByBrandFound")
			void findByBrandFoundTest() {
					
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByBrand("Toyota");
				assertEquals(false, hybridCarFoundList.isEmpty());
	}
		
		
		@Order(14)
		@Test
		@DisplayName("HybridCarServiceFindByBrandNotFound")
			void findByBrandNotFoundTest() {
					
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByBrand("Seat");
				assertEquals(true, hybridCarFoundList.isEmpty());
						
		}
		
		
		@Order(15)
		@Test
		@DisplayName("HybridCarServiceFindByBrandNull")
			void findByBrandNullTest() {
							
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByBrand(null);
				assertNotNull(hybridCarFoundList);
							
		}
			

		@Order(16)
		@Test
		@DisplayName("HybridCarServiceFindByBrandBlank")
			void findByBrandBlankTest() {
			
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByBrand("");
				assertNotNull(hybridCarFoundList);
							
		}
		

		@Order(17)
		@Test
		@DisplayName("HybridCarServiceFindByDoorsFound")
			void findByDoorsFoundTest() {
							
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByDoors(3);
				assertEquals(false, hybridCarFoundList.isEmpty());
									
		}
		
		@Order(18)
		@Test
		@DisplayName("HybridCarServiceFindByDoorsNotFound")
			void findByDoorsNotFoundTest() {
							
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByDoors(12);
				assertEquals(true, hybridCarFoundList.isEmpty());
									
		}
		
		@Order(19)
		@Test
		@DisplayName("HybridCarServiceFindByDoorsNull")
			void findByDoorsNullTest() {
								
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByDoors(null);
				assertNotNull(hybridCarFoundList);
									
		}
		
		@Order(20)
		@Test
		@DisplayName("HybridCarServiceFindByDoorsNegative")
			void findByDoorsNegativeTest() {
								
				List<HybridCar> hybridCarFoundList = hybridCarImpl.findByDoors(-1);
				assertNotNull(hybridCarFoundList);
									
		}
		
		
		@Order(21)
		@Test
		@DisplayName("HybridCarServiceDeleteFound")
			void DeleteFoundTest() {
							
				Boolean deleted = hybridCarImpl.delete(5L);
				assertEquals(true, deleted);
				assertEquals(4, hybridCarImpl.count());			
		
		}
		
		@Order(22)
		@Test
		@DisplayName("HybridCarServiceDeleteNull")
			void DeleteNULLTest() {
				
				Boolean deleted = hybridCarImpl.delete(null);
				assertEquals(false, deleted);
				assertEquals(4, hybridCarImpl.count());	
		}
		
		@Order(23)
		@Test
		@DisplayName("HybridCarServiceDeleteNotFound")
			void DeleteNotFoundTest() {
				
				Boolean deleted = hybridCarImpl.delete(10L);
				assertEquals(false, deleted);
				assertEquals(4, hybridCarImpl.count());		
			
		}
		
		@Order(24)
		@Test
		@DisplayName("HybridCarServiceDeleteNegative")
			void DeleteNegativeTest() {
							
				Boolean deleted = hybridCarImpl.delete(-3L);
				assertEquals(false, deleted);
				assertEquals(4, hybridCarImpl.count());		
		}
		
		@Order(25)
		@Test
		@DisplayName("HybridCarServiceDeleteAll")
			void DeleteAllTest() {
					
			hybridCarImpl.deleteAll();;
				assertEquals(0, hybridCarImpl.count());			
		}
		
		@Order(26)
		@Test
		@DisplayName("HybridCarServiceDeleteAllEmptyList")
			void DeleteAllEmptyListTest() {
					
				hybridCarImpl.deleteAll();;
				assertEquals(0, hybridCarImpl.count());			
		}
		
		@Order(27)
		@Test
		@DisplayName("HybridCarServiceDeleteOneEmptyList")
			void DeleteOneEmptyListTest() {
				
				Boolean deleted = hybridCarImpl.delete(10L);
				assertEquals(0, hybridCarImpl.count());	
				assertEquals(false, deleted);
				assertEquals(0, hybridCarImpl.count());		
			
		}
		
		@Order(28)
		@Test
		@DisplayName("HybridCarServiceSaveCreateFirstIdOnEmptyList")
		void saveCreateFirstIdOnEmptyListTest() {
			HybridCar hybridCarFirst = new HybridCar(0L,
	    			new Battery(),
					new AirConditioner(),
					new Engine(),
					new HybridPiece(),
					"Zero Car",
					"Red & White",
					2);
			hybridCarImpl.save(hybridCarFirst);
					
			assertEquals("Zero Car", hybridCarImpl.findOne(1L).getBrand());
			assertEquals(1, hybridCarImpl.count());
		}
	

	

}
