package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.GasCar;


public interface GasCarService {
	Integer count();

    List<GasCar> findAll();

    GasCar findOne(Long id);
    
    // Filtros
    List<GasCar> findByColor(String color);
    
    List<GasCar> findByBrand(String brand);
    
    List<GasCar> findByDoors(Integer doors);

    GasCar save(GasCar gasCar);

    boolean delete(Long id);

    void deleteAll();

}
