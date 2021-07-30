package com.example.demo.service;

import java.util.List;



import com.example.demo.domain.ElectricCar;


public interface ElectricCarService {
	
	Integer count();

    List<ElectricCar> findAll();

    ElectricCar findOne(Long id);
    
    // Filtros
    List<ElectricCar> findByColor(String color);
    
    List<ElectricCar> findByBrand(String brand);
    
    List<ElectricCar> findByDoors(Integer doors);
    

    ElectricCar save(ElectricCar electricCar);

    boolean delete(Long id);

    void deleteAll();

}
