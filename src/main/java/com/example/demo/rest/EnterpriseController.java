package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Enterprise;
import com.example.demo.dto.EnterpriseListDTO;
import com.example.demo.dto.CountDTO;
//import com.example.demo.dto.MessageDTO;

import com.example.demo.service.EnterpriseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class EnterpriseController {
	
	private final Logger log = LoggerFactory.getLogger(EnterpriseController.class);
	// dependencia
	private EnterpriseService enterpriseService; 
	
	public EnterpriseController(EnterpriseService enterprisesRepository) { // spring inyecta la dependencia
		this.enterpriseService = enterprisesRepository;
	}
//	================= FILTROS =================
//	
//	@GetMapping("/cars/doors/{doors}")
//	// @ApiIgnore
//	@ApiOperation("Buscar coches filtrando por numero puertas")
//	public List<Car> findByDoors(@PathVariable Integer doors){
//		log.info("REST request to find cars by num doors");
//		return this.carService.findByDoors(doors);
//	}
	
	/**
	 * http://localhost:8080/api/cars/1
	 */
	
//  ================= METODOS CRUD ===================
	@GetMapping("/enterprises/{id}")
	@ApiOperation("Buscar empresa por id")
	public ResponseEntity<Enterprise> findById(@ApiParam("Clave primaria Enterprise") @PathVariable Long id) {
		log.info("REST request to find one enterprise");

		Optional<Enterprise> enterpriseOpt = this.enterpriseService.findById(id);
		
		// opcion 1
		if (enterpriseOpt.isPresent()) 
			return ResponseEntity.ok(enterpriseOpt.get());
		
		return ResponseEntity.notFound().build();
	
	}
	
	/**
	 * http://localhost:8080/api/enterprises
	 */
	@GetMapping("/enterprises")
	public List<Enterprise> findAll(){
		log.info("REST request to find all enterprise");
		return this.enterpriseService.findAll();
	}
	
	// create one
	@PostMapping("/enterprises")
	public ResponseEntity<Enterprise> create(@RequestBody Enterprise enterprise){
		log.info("REST request to create a new enterprise");
		
		if (enterprise.getId() != null) { // HAY ID - LA EMPRESA YA EXISTE NO SE PUEDE CREAR DE NUEVO
			log.warn("Trying to create a new enterprise with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(this.enterpriseService.save(enterprise));
		
	}
	
	// update 
	@PutMapping("/enterprises")
	public ResponseEntity<Enterprise> update(@RequestBody Enterprise enterprise) {
		log.info("REST request to update an existing enterprise");
		if (enterprise.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE EL COCHE A ACTUALIZAR
			log.warn("Trying to update an existing enterprise without id");
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.enterpriseService.save(enterprise));
		
	}
	
	// delete one
	@DeleteMapping("/enterprises/{id}")
	public ResponseEntity<Enterprise> delete(@PathVariable Long id){
		log.info("REST request to delete an existing Enterprises");
		
		this.enterpriseService.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// delete all
	
	@DeleteMapping("/enterprises")
	public ResponseEntity<Enterprise> deleteAll(){
		log.info("REST request to delete all Enterprises");
		
		this.enterpriseService.deleteAll();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/enterprises/count")
	public ResponseEntity<CountDTO> count(){
		log.info("REST request to count all cars");
		Long count = this.enterpriseService.count();
		CountDTO dto = new CountDTO(count);
		dto.setMessage("Que tenga usted un feliz dia :)");
		return ResponseEntity.ok(dto);
	}
//	
//	@GetMapping("/cars/hello")
//	public ResponseEntity<String> hello(){
//		return ResponseEntity.ok("Hello");
//	}
//	
//	@GetMapping("/cars/hello2")
//	public ResponseEntity<MessageDTO> hello2(){
//		return ResponseEntity.ok(new MessageDTO("Hello"));
//	}
//	
	// @PostMapping("/cars/deletemany")
	@DeleteMapping("/enterprises/deletemany")
	public ResponseEntity<Enterprise> deleteMany(@RequestBody EnterpriseListDTO enterpriseListDto){
		
		this.enterpriseService.deleteAll(enterpriseListDto.getCars());
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/enterprises/deletemany/{ids}")
	public ResponseEntity<Enterprise> deleteMany(@PathVariable List<Long> ids){
		this.enterpriseService.deleteAllById(ids);
		
		return ResponseEntity.noContent().build();
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
