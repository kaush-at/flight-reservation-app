package com.kaush.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kaush.flightcheckin.integration.dtos.Reservation;
import com.kaush.flightcheckin.integration.dtos.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATIONS_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATIONS_REST_URL+id, Reservation.class);  // access karanna one url eka and response eka labena object type eka
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATIONS_REST_URL, request, Reservation.class);
		return reservation;
	}

	// above url exactly same there fore we can create therefore we can extract it to constant
}
