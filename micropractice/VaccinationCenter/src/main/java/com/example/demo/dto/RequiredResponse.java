package com.example.demo.dto;

import java.util.List;

import com.example.demo.Model.VaccinationCenter;

public class RequiredResponse {
	private VaccinationCenter center;
	private Citizen citizens;
	public RequiredResponse() {
		// TODO Auto-generated constructor stub
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public Citizen getCitizens() {
		return citizens;
	}
	public void setCitizens(Citizen citizens) {
		this.citizens = citizens;
	}
	

}
