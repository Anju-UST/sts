package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.VaccinationCenter;

@Repository
public interface CenterRepo  extends JpaRepository<VaccinationCenter, Integer>{

}
