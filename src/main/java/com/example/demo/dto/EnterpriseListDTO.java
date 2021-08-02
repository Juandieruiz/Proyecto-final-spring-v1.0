package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Enterprise;

public class EnterpriseListDTO {

	private List<Enterprise> enterprises;
	
	public EnterpriseListDTO() {}

	public List<Enterprise> getCars() {
		return enterprises;
	}

	public void setCars(List<Enterprise> enterprises) {
		this.enterprises = enterprises;
	}

}
