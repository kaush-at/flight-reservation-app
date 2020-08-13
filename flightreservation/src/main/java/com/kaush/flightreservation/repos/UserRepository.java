package com.kaush.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email); // thanks to spring data we no need to write query => follow the naming convention

}
