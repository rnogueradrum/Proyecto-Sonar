package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.HybridCar;


public interface HybridCarService {
	
	Integer count();

    List<HybridCar> findAll();

    HybridCar findOne(Long id);
    
    // Filtros
    List<HybridCar> findByColor(String color);
    
    List<HybridCar> findByBrand(String brand);

    HybridCar save(HybridCar hybridCar);

    boolean delete(Long id);

    void deleteAll();

}
