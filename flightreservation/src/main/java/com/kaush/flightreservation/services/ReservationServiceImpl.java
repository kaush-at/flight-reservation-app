package com.kaush.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaush.flightreservation.dtos.ReservationRequest;
import com.kaush.flightreservation.entities.Flight;
import com.kaush.flightreservation.entities.Passenger;
import com.kaush.flightreservation.entities.Reservation;
import com.kaush.flightreservation.repos.FlightRepository;
import com.kaush.flightreservation.repos.PassengerRepository;
import com.kaush.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// make payment => invoke third party api to do the payment (skkipping that process)
		
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepo.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerRepo.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		
		return reservationRepo.save(reservation);
	}

}
