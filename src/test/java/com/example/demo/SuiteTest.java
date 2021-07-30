package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.example") 
@SuiteDisplayName("Suite de testing") 
public class SuiteTest {

	/**
	 * El ejercicio solicita la cobertura de las clases indicadas
	 * 
	 * Suite Test
	 * 
	 * General: (100%)
	 * 
	 * CarFacade
	 * CarFactory
	 * 
	 * Services: (100%)
	 * 
	 * ElectricCarImpl
	 * HybridCarImpl
	 * GasCarServiceImpl
	 */


}
