package com.kaush.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaush.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
