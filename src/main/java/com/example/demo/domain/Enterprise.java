package com.example.demo.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "enterprises")
public class Enterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Clave primaria id ficticio tipo Long autoincremental")
	private Long id;

	@Column(name = "data")
	private Integer cif;
	private String name; // CONTAINS
	private Integer products;
	private Integer employees;
	private LocalDate yearsmarket; // BETWEEN


//private LocalDate releaseDate; // BETWEEN
//	private Boolean available; // True or False

	public Enterprise(Long id, Integer cif, String name, Integer products, Integer employees, LocalDate yearsmarket) {
		super();
		this.id = id;
		this.cif = cif;
		this.name = name;
		this.products = products;
		this.employees = employees;
		this.yearsmarket = yearsmarket;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getCif() {
		return cif;
	}


	public void setCif(Integer cif) {
		this.cif = cif;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getProducts() {
		return products;
	}


	public void setProducts(Integer products) {
		this.products = products;
	}


	public Integer getEmployees() {
		return employees;
	}


	public void setEmployees(Integer employees) {
		this.employees = employees;
	}


	public LocalDate getYearsmarket() {
		return yearsmarket;
	}


	public void setYearsmarket(LocalDate yearsmarket) {
		this.yearsmarket = yearsmarket;
	}


	@Override
	public String toString() {
		return "Enterprise [id=" + id + ", cif=" + cif + ", name=" + name + ", products=" + products + ", employees="
				+ employees + ", yearsmarket=" + yearsmarket + "]";
	}
	
	
}
