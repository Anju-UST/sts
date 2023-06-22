package com.ust.citizen.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.citizen.Entity.Citizen;
import com.ust.citizen.Repo.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	CitizenRepo repo;
	
	@RequestMapping(path ="/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Citizen> getById(@PathVariable Integer id) {
		
		Optional<Citizen> listCitizen = repo.findById(id);
		if(listCitizen.isPresent()) {
			
		return new ResponseEntity<>(listCitizen.get(), HttpStatus.OK);
		}
//		return ResponseEntity.status(HttpStatus.OK).body(listCitizen);
		else 
			return null;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>addCitizen(@RequestBody Citizen c){
		Citizen citizen=repo.save(c);
		return ResponseEntity.ok().body(citizen);
		
	}
	
	
	
	

}
