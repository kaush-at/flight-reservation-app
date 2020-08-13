package com.kaush.flightreservation.services;

import com.kaush.flightreservation.dtos.ReservationRequest;
import com.kaush.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
