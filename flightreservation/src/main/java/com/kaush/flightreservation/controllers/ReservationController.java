package com.kaush.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaush.flightreservation.dtos.ReservationRequest;
import com.kaush.flightreservation.entities.Flight;
import com.kaush.flightreservation.entities.Reservation;
import com.kaush.flightreservation.repos.FlightRepository;
import com.kaush.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	ReservationService reservationService;
	

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long id, ModelMap modelMap) {
		System.out.println("showCompleteReservation method get called...");
		Flight flight = flightRepo.findById(id).get();
		modelMap.addAttribute("flightInfo", flight);
		return "completeReservation";
		
	}
	
	@RequestMapping(value="/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created with ID : "+reservation.getId());
		return "reservationConfirmation";
		
	}
}
