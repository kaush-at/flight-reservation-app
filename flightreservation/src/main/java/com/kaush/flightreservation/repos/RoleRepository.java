package com.kaush.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
