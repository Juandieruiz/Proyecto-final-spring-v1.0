package com.example.demo.service;

//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;

import com.example.demo.domain.Enterprise;
import com.example.demo.repository.EnterpriseRepository;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	private static final Integer MIN_EMPLOYEES = 5;

	private final Logger log = LoggerFactory.getLogger(EnterpriseServiceImpl.class);
	
	private EnterpriseRepository enterpriseRepository;
	
	public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
		this.enterpriseRepository = enterpriseRepository;
	}
	
	@Override
	public List<Enterprise> findAll() {
		log.info("Executing findAll Enterprises");
		return this.enterpriseRepository.findAll();
	}

	@Override
	public Optional<Enterprise> findById(Long id) {
		log.info("Executing findById");
		return this.enterpriseRepository.findById(id);
	}

//	@Override
//	public List<Car> findByDoors(Integer doors) {
//		log.info("Searching cars by doors");
//		if (doors < MIN_DOORS) {
//			log.warn("Trying to sarch less than allowed doors");
//			return new ArrayList<>();
//		}
//		
//		return this.carRepository.findByDoors(doors);
//	}
//
	@Override
	public Long count() {
		log.info("Get total number of enterprises");
		return this.enterpriseRepository.count();
	}

	@Override
	public Enterprise save(Enterprise enterprise) {
		log.info("Creating / Updating enterprise");
		// pre
		if(!this.validateEnterprise(enterprise)) 
			return null;
		
		// actions
		// find template from db
		Enterprise enterpriseDB = this.enterpriseRepository.save(enterprise);
		
		// post:
		// enviar notificacion
		// this.notificationService(NotificationType.CREATION, car);
		
		return enterpriseDB;
	}
	
	private boolean validateEnterprise(Enterprise enterprise) {
		// car null validation
		if (enterprise == null) {
			log.warn("Trying to create null enterprise");
			return false;
		}
		// num doors validation
		if (enterprise.getEmployees() == null || enterprise.getEmployees() < MIN_EMPLOYEES) {
			log.warn("Trying to create enterprise with not allowed number of employees");
			return false;
		}
		// color validation
		// .... 
		
		return true;
	}
//
	@Override
	public void deleteById(Long id) {
		log.info("Deleting enterprise by id");
		if (id == null || id < 0 || id == 0) {
			log.warn("Trying to delete enterprise with wrong id");
			return;
		}

		try {
			this.enterpriseRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete enterprise by id {}", id, e);
		}

	}

	@Override
	public void deleteAll() {
		log.info("Deleting cars");
		this.enterpriseRepository.deleteAll();
	}

	@Override
	public void deleteAll(List<Enterprise> enterprise) {
		log.info("Deleting enterprise by id");
		if (CollectionUtils.isEmpty(enterprise)) {
			log.warn("Trying to delete an empty or null enterprise list");
			return;
		}
		this.enterpriseRepository.deleteAll(enterprise);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		log.info("Deleting enterprise by id");
		if (CollectionUtils.isEmpty(ids)) {
			log.warn("Trying to delete an empty or null enterprise list");
			return;
		}
		this.enterpriseRepository.deleteAllById(ids);
		
	}
//
//	@Override
//	public List<Car> findByManufacturerAndModel(String manufacturer, String model) {
//		
//		if(!StringUtils.hasLength(manufacturer) || !StringUtils.hasLength(model))
//			return new ArrayList<>();
//			
//		return this.carRepository.findByManufacturerAndModel(manufacturer, model);
//	}
//
//	@Override
//	public List<Car> findByDoorsGreaterThanEqual(Integer doors){
//		if(doors == null || doors < 0)
//			return new ArrayList<>();
//		
//		return this.carRepository.findByDoorsGreaterThanEqual(doors);
//	}
//
//	@Override
//	public List<Car> findByModelContaining(String model) {
//		return this.carRepository.findByModelContaining(model);
//	}
//
//	@Override
//	public List<Car> findByYearIn(List<Integer> years) {
//		return this.carRepository.findByYearIn(years);
//	}
//
//	@Override
//	public List<Car> findByYearBetween(Integer startYear, Integer endYear) {
//		return this.carRepository.findByYearBetween(startYear, endYear);
//	}
//
//	@Override
//	public List<Car> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate) {
//		return this.carRepository.findByReleaseDateBetween(startDate, endDate);
//	}
//
//	@Override
//	public List<Car> findByAvailableTrue() {
//		return this.carRepository.findByAvailableTrue();
//
//	}
//
//	@Override
//	public Long deleteAllByAvailableFalse() {
//		return this.carRepository.deleteAllByAvailableFalse();
//	}
//	

}
