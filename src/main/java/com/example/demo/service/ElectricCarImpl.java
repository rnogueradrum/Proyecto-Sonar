package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.ElectricPiece;
import com.example.demo.domain.pieces.Engine;

@Service
public class ElectricCarImpl implements ElectricCarService {

	/**
	 * Database emulation
	 */
    private static final Map<Long, ElectricCar> cars = new HashMap<>();

    static{ 

    	ElectricCar electricCar1 = new ElectricCar(1L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new ElectricPiece(),
				"Tesla",
				"Red");
		
    	ElectricCar electricCar2 = new ElectricCar(2L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new ElectricPiece(),
				"Mazda",
				"Black");
		
    	ElectricCar electricCar3 = new ElectricCar(3L,
    			new Battery(),
				new AirConditioner(),
				new Engine(),
				new ElectricPiece(),
				"Nissan",
				"Blue Sky");
		
		
		cars.put(1L, electricCar1);
		cars.put(2L, electricCar2);
		cars.put(3L, electricCar3);
    }
    
	@Override
	public Integer count() {
		return cars.keySet().size();
	}

	@Override
	public List<ElectricCar> findAll() {
		return new ArrayList<>(cars.values());
		
	}

	@Override
	public ElectricCar findOne(Long id) {
		return cars.get(id);
	}

	@Override
	public List<ElectricCar> findByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElectricCar> findByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ElectricCar save(ElectricCar electricCar) {
		
        if (electricCar.getId() == null || electricCar.getId() == 0L) 
        	electricCar.setId(getMaxCarId() + 1); 

        // en caso de actualizar primero lo eliminamos
        cars.remove(electricCar.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el smartphone en el mapa
        cars.put(electricCar.getId(), electricCar);
        return electricCar;
	}
	
	/**
     * Highest cars Map id
     * @return
     */
    private Long getMaxCarId() {
    	if (cars.isEmpty())
			return 0L;

        return Collections.max(cars.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }


	@Override
	public boolean delete(Long id) {
		if (id == null || !cars.containsKey(id))
            return false;
        cars.remove(id);
        return true;
	}

	@Override
	public void deleteAll() {
		if (!cars.isEmpty())
            cars.clear();

	}
	
	
}
