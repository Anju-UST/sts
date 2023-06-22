package com.ust.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.security.model.User;



public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User>findByUserName(String username);

}
