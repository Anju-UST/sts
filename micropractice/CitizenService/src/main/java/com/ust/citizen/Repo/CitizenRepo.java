package com.ust.citizen.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.citizen.Entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Integer>{
//	public Citizen findByVaccinationCenterId(Integer id);

}
