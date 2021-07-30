package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.GasCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.OilTank;

@Service
public class GasCarServiceImpl implements GasCarService {

	
	/**
	 * Database emulation
	 * 
	 */
    private static final Map<Long, GasCar> cars = new HashMap<>();

    static{  

		GasCar gasCar1 = new GasCar(1L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new OilTank(),
				"Honda",
				"Red",
				3);
			
		
		GasCar gasCar2 = new GasCar(2L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new OilTank(),
				"Ferrari",
				"Yellow",
				3);
		
		GasCar gasCar3 = new GasCar(3L, 
				new Battery(),
				new AirConditioner(),
				new Engine(),
				new OilTank(),
				"Aston Martin",
				"Grey",
				5);
		
		gasCar1.getBattery().setCharged(true);
		gasCar1.getAirConditioner().airOn();
		gasCar1.getEngine().setIgnition(true);
		gasCar1.getOilTank().setGasTank(true);
		
		gasCar2.getBattery().setCharged(true);
		gasCar2.getAirConditioner().airOn();
		gasCar2.getEngine().setIgnition(true);
		gasCar2.getOilTank().setGasTank(true);
		
		gasCar3.getBattery().setCharged(true);
		gasCar3.getAirConditioner().airOn();
		gasCar3.getEngine().setIgnition(true);
		gasCar3.getOilTank().setGasTank(true);
		
		cars.put(1L, gasCar1);
		cars.put(2L, gasCar2);
		cars.put(3L, gasCar3);
    }
    
	@Override
	public Integer count() {
		return cars.size();
	}

	@Override
	public List<GasCar> findAll() {
		return new ArrayList<>(cars.values());
		
	}

	@Override
	public GasCar findOne(Long id) {
		return cars.get(id);
	}

	@Override
	public List<GasCar> findByColor(String color) {
		List<GasCar> byColor = new ArrayList<>();
		for (Map.Entry<Long, GasCar> entrada: cars.entrySet()) {
				
	          if (entrada.getValue().getColor().equals(color)) {
	        	 byColor.add(entrada.getValue());
	          }//if
	        }//for
		return byColor;
	}

	@Override
	public List<GasCar> findByBrand(String brand) {
		List<GasCar> byBrand = new ArrayList<>();
		for (Map.Entry<Long, GasCar> entrada: cars.entrySet()) {
				
	          if (entrada.getValue().getBrand().equals(brand)) {
	        	 byBrand.add(entrada.getValue());
	        	 
	          }//if
	        }//for
		return byBrand;
	}
	

	@Override
	public List<GasCar> findByDoors(Integer doors) {
		List<GasCar> byDoors = new ArrayList<>();
		for (Map.Entry<Long, GasCar> entrada: cars.entrySet()) {
				
	          if (entrada.getValue().getDoors().equals(doors)) {
	        	 byDoors.add(entrada.getValue());
	        	 
	          }//if
	        }//for
		return byDoors;
	}

	@Override
	public GasCar save(GasCar gasCar) {
		
        if (gasCar.getId() == null || gasCar.getId() == 0L) 
        	gasCar.setId(getMaxCarId() + 1); 

        // en caso de actualizar primero lo eliminamos
        cars.remove(gasCar.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el smartphone en el mapa
        cars.put(gasCar.getId(), gasCar);
        return gasCar;
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
