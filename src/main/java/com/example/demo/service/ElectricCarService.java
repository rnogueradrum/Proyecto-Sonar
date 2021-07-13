package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ElectricCar;


public interface ElectricCarService {
	
	Integer count();

    List<ElectricCar> findAll();

    ElectricCar findOne(Long id);
    
    // Filtros
    List<ElectricCar> findByColor(String color);
    
    List<ElectricCar> findByBrand(String brand);

    ElectricCar save(ElectricCar electricCar);

    boolean delete(Long id);

    void deleteAll();

}
