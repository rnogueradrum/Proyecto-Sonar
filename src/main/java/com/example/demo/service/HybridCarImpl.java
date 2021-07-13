package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.HybridPiece;


@Service
public class HybridCarImpl implements HybridCarService {


	/**
	 * Database emulation
	 */
    private static final Map<Long, HybridCar> cars = new HashMap<>();

    static{ 

    	HybridCar hybridCar1 = new HybridCar(1L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new HybridPiece(),
				"Toyota",
				"White");
		
    	HybridCar hybridCar2 = new HybridCar(2L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new HybridPiece(),
				"Rolls Royce",
				"Purple");
		
    	HybridCar hybridCar3 = new HybridCar(3L,
    			new Battery(),
				new AirConditioner(),
				new Engine(),
				new HybridPiece(),
				"BMW",
				"Ocean Blue");
		
		
		cars.put(1L, hybridCar1);
		cars.put(2L, hybridCar2);
		cars.put(3L, hybridCar3);
    }
    
	@Override
	public Integer count() {
		return cars.keySet().size();
	}

	@Override
	public List<HybridCar> findAll() {
		return new ArrayList<>(cars.values());
		
	}

	@Override
	public HybridCar findOne(Long id) {
		return cars.get(id);
	}

	@Override
	public List<HybridCar> findByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HybridCar> findByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HybridCar save(HybridCar hybridCar) {
		
        if (hybridCar.getId() == null || hybridCar.getId() == 0L) 
        	hybridCar.setId(getMaxCarId() + 1); 

        // en caso de actualizar primero lo eliminamos
        cars.remove(hybridCar.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el smartphone en el mapa
        cars.put(hybridCar.getId(), hybridCar);
        return hybridCar;
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
