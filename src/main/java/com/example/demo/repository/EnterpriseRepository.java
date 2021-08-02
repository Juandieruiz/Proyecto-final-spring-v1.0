package com.example.demo.repository;

//import java.time.LocalDate;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long>{

//	List<Enterprise> findByEmployees(Integer employees);
	
//	List<Enterprise> findByManufacturerAndModel(String manufacturer, String model);
//	
//	List<Enterprise> findByDoorsGreaterThanEqual(Integer doors);
//	
//	List<Enterprise> findByModelContaining(String model);
//	
//	List<Enterprise> findByYearIn(List<Integer> years);
//	
//	List<Enterprise> findByYearBetween(Integer startYear, Integer endYear);
//	
//	List<Enterprise> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
//	
//	List<Enterprise> findByAvailableTrue();
//	
//	Long deleteAllByAvailableFalse();
//	
}