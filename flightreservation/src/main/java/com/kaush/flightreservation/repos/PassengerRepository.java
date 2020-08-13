package com.kaush.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
