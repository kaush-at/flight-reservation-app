package com.kaush.flightcheckin.integration;

import com.kaush.flightcheckin.integration.dtos.Reservation;
import com.kaush.flightcheckin.integration.dtos.ReservationUpdateRequest;

// this class is responsible for making the web service calls
public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
