package com.example.demo.service;

//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Enterprise;

public interface EnterpriseService {
	
	// spring repository methods
	
	List<Enterprise> findAll();

	Optional<Enterprise> findById(Long id);
	
	Long count();
	
	Enterprise save(Enterprise enterprise);
	
	void deleteById(Long id);
	
	void deleteAll();
	
	void deleteAll(List<Enterprise> enterprises);
	
	void deleteAllById(List<Long> ids);
	
	// custom methods
//	
//	List<Car> findByDoors(Integer doors);
//	
//	List<Car> findByManufacturerAndModel(String manufacturer, String model);
//	
//	List<Car> findByDoorsGreaterThanEqual(Integer doors);
//	
//	List<Car> findByModelContaining(String model);
//	
//	List<Car> findByYearIn(List<Integer> years);
//	
//	List<Car> findByYearBetween(Integer startYear, Integer endYear);
//	
//	List<Car> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
//	
//	List<Car> findByAvailableTrue();
//	
//	Long deleteAllByAvailableFalse();
//	
	
}
