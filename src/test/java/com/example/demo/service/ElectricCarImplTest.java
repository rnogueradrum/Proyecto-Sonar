package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.ElectricPiece;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElectricCarImplTest {
	
	ElectricCarImpl electricCarImpl; 
	
	@BeforeEach
	void setUp() throws Exception {
		electricCarImpl = new ElectricCarImpl() ;
		}
	
	@Order(1)
	@Test
	@DisplayName("ElectricCarImplInstance")
	void ElectricCarImplInstanceTest() {
		Integer elementos = electricCarImpl.count();
		assertTrue(electricCarImpl instanceof ElectricCarImpl);
		assertNotNull(elementos);
	}
	
	@Order(2)
	@Test
	@DisplayName("ElectricCarImplCount")
	void countTest() {
		Integer elementos = electricCarImpl.count();
		assertEquals(3, elementos);
		
		electricCarImpl.delete(3L);		
		elementos = electricCarImpl.count();
		assertEquals(2,elementos);
	}
	
	@Order(3)
	@Test
	@DisplayName("electricCarImplFindAll")
	void findAllTest() {
		List<ElectricCar> electricCarList = electricCarImpl.findAll();
		assertEquals(electricCarImpl.count(), electricCarList.size());
	}
	
	@Order(4)
		@Test
		@DisplayName("electricCarImplFindOne")
		void findOneTest() {
			ElectricCar electricCarFound = electricCarImpl.findOne(1L);
			assertNotNull(electricCarFound);
			
		}
	
	@Order(5)
	@Test
	@DisplayName("electricCarImplFindOneNull")
	void findOneNullTest() {
		ElectricCar electricCarFound = electricCarImpl.findOne(null);
		assertNull(electricCarFound);
		electricCarFound = electricCarImpl.findOne(10L);
		assertNull(electricCarFound);
		
	}
	
	
	@Order(6)
	@Test
	@DisplayName("electricCarImplSaveUpdate")
	void saveUpdateTest() {
		ElectricCar electricCar4 = new ElectricCar(3L,
    			new Battery(),
				new AirConditioner(),
				new Engine(),
				new ElectricPiece(),
				"BMW",
				"Deep Blue",
				3);
		electricCarImpl.save(electricCar4);
				
		assertEquals("BMW", electricCarImpl.findOne(3L).getBrand());
	}
	
	@Order(7)
		@Test
		@DisplayName("ElectricCarServiceSaveCreateZeroId")
		void saveCreateZeroIdTest() {
		ElectricCar electricCar5 = new ElectricCar(0L,
    			new Battery(),
				new AirConditioner(),
				new Engine(),
				new ElectricPiece(),
				"Fiat",
				"Grey",
				2);
		electricCarImpl.save(electricCar5);
					
			assertEquals("Fiat", electricCarImpl.findOne(4L).getBrand());
		
		}
		
		@Order(8)
		@Test
		@DisplayName("ElectricCarServiceSaveCreateNullId")
		void saveCreateNullIdTest() {	
			ElectricCar electricCar6 = new ElectricCar(null,
	    			new Battery(),
					new AirConditioner(),
					new Engine(),
					new ElectricPiece(),
					"Renault",
					"Silver",
					5);
			electricCarImpl.save(electricCar6);
					
			assertEquals("Renault", electricCarImpl.findOne(5L).getBrand());
		}
			
		
		@Order(9)
		@Test
		@DisplayName("ElectricCarServiceFindByColorFound")
			void findByColorFoundTest() {
					
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByColor("Red");
				assertEquals(false, electricCarFoundList.isEmpty());
				
			}
		
		
		@Order(10)
		@Test
		@DisplayName("ElectricCarServiceFindByColorNotFound")
			void findByColorNotFoundTest() {
			
			List<ElectricCar> electricCarFoundList = electricCarImpl.findByColor("Green");
			assertEquals(true, electricCarFoundList.isEmpty());
		
		}
		
		
		@Order(11)
		@Test
		@DisplayName("ElectricCarServiceFindByColorNull")
			void findByColorNullTest() {
				
			List<ElectricCar> electricCarFoundList = electricCarImpl.findByColor(null);
			assertNotNull(electricCarFoundList);
			
		}
		
		@Order(12)
		@Test
		@DisplayName("ElectricCarServiceFindByColorBlank")
			void findByColorBlankTest() {
					
			List<ElectricCar> electricCarFoundList = electricCarImpl.findByColor("");
			assertNotNull(electricCarFoundList);
						
		}
		
		
		@Order(13)
		@Test
		@DisplayName("ElectricCarServiceFindByBrandFound")
			void findByBrandFoundTest() {
					
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByBrand("Tesla");
				assertEquals(false, electricCarFoundList.isEmpty());
	}
		
		
		@Order(14)
		@Test
		@DisplayName("ElectricCarServiceFindByBrandNotFound")
			void findByBrandNotFoundTest() {
					
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByBrand("Seat");
				assertEquals(true, electricCarFoundList.isEmpty());
						
		}
		
		
		@Order(15)
		@Test
		@DisplayName("ElectricCarServiceFindByBrandNull")
			void findByBrandNullTest() {
							
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByBrand(null);
				assertNotNull(electricCarFoundList);
							
		}
			

		@Order(16)
		@Test
		@DisplayName("ElectricCarServiceFindByBrandBlank")
			void findByBrandBlankTest() {
			
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByBrand("");
				assertNotNull(electricCarFoundList);
							
		}
		

		@Order(17)
		@Test
		@DisplayName("ElectricCarServiceFindByDoorsFound")
			void findByDoorsFoundTest() {
							
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByDoors(3);
				assertEquals(false, electricCarFoundList.isEmpty());
									
		}
		
		@Order(18)
		@Test
		@DisplayName("ElectricCarServiceFindByDoorsNotFound")
			void findByDoorsNotFoundTest() {
							
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByDoors(12);
				assertEquals(true, electricCarFoundList.isEmpty());
									
		}
		
		@Order(19)
		@Test
		@DisplayName("ElectricCarServiceFindByDoorsNull")
			void findByDoorsNullTest() {
								
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByDoors(null);
				assertNotNull(electricCarFoundList);
									
		}
		
		@Order(20)
		@Test
		@DisplayName("ElectricCarServiceFindByDoorsNegative")
			void findByDoorsNegativeTest() {
								
				List<ElectricCar> electricCarFoundList = electricCarImpl.findByDoors(-1);
				assertNotNull(electricCarFoundList);
									
		}
		
		
		@Order(21)
		@Test
		@DisplayName("ElectricCarServiceDeleteFound")
			void DeleteFoundTest() {
							
				Boolean deleted = electricCarImpl.delete(5L);
				assertEquals(true, deleted);
				assertEquals(4, electricCarImpl.count());			
		
		}
		
		@Order(22)
		@Test
		@DisplayName("ElectricCarServiceDeleteNull")
			void DeleteNULLTest() {
				
				Boolean deleted = electricCarImpl.delete(null);
				assertEquals(false, deleted);
				assertEquals(4, electricCarImpl.count());	
		}
		
		@Order(23)
		@Test
		@DisplayName("ElectricCarServiceDeleteNotFound")
			void DeleteNotFoundTest() {
				
				Boolean deleted = electricCarImpl.delete(10L);
				assertEquals(false, deleted);
				assertEquals(4, electricCarImpl.count());		
			
		}
		
		@Order(24)
		@Test
		@DisplayName("ElectricCarServiceDeleteNegative")
			void DeleteNegativeTest() {
							
				Boolean deleted = electricCarImpl.delete(-3L);
				assertEquals(false, deleted);
				assertEquals(4, electricCarImpl.count());		
		}
		
		@Order(25)
		@Test
		@DisplayName("ElectricCarServiceDeleteAll")
			void DeleteAllTest() {
					
			electricCarImpl.deleteAll();;
				assertEquals(0, electricCarImpl.count());			
		}
		
		@Order(26)
		@Test
		@DisplayName("ElectricCarServiceDeleteAllEmptyList")
			void DeleteAllEmptyListTest() {
					
				electricCarImpl.deleteAll();;
				assertEquals(0, electricCarImpl.count());			
		}
		
		@Order(27)
		@Test
		@DisplayName("ElectricCarServiceDeleteOneEmptyList")
			void DeleteOneEmptyListTest() {
				
				Boolean deleted = electricCarImpl.delete(10L);
				assertEquals(0, electricCarImpl.count());	
				assertEquals(false, deleted);
				assertEquals(0, electricCarImpl.count());		
			
		}
		
		@Order(28)
		@Test
		@DisplayName("ElectricCarServiceSaveCreateFirstIdOnEmptyList")
		void saveCreateFirstIdOnEmptyListTest() {
			ElectricCar electricCarFirst = new ElectricCar(0L,
	    			new Battery(),
					new AirConditioner(),
					new Engine(),
					new ElectricPiece(),
					"Zero Car",
					"Red & White",
					2);
			electricCarImpl.save(electricCarFirst);
					
			assertEquals("Zero Car", electricCarImpl.findOne(1L).getBrand());
			assertEquals(1, electricCarImpl.count());
		}
	

	


}
