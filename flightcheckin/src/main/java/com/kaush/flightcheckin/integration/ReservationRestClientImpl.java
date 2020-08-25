package com.kaush.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kaush.flightcheckin.integration.dtos.Reservation;
import com.kaush.flightcheckin.integration.dtos.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Value("${com.kaush.flightchecking.integration.reservation.url}")
	private String RESERVATIONS_REST_URL;

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATIONS_REST_URL+id, Reservation.class);  
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATIONS_REST_URL, request, Reservation.class);
		return reservation;
	}

}
