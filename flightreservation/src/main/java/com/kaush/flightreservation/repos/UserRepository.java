package com.kaush.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email); 

}
