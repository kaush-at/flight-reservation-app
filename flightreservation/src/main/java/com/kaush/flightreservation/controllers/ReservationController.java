package com.kaush.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaush.flightreservation.entities.Flight;
import com.kaush.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepo;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long id, ModelMap modelMap) {
		System.out.println("showCompleteReservation method get called...");
		Flight flight = flightRepo.findById(id).get();
		modelMap.addAttribute("flightInfo", flight);
		return "completeReservation";
		
	}
}
