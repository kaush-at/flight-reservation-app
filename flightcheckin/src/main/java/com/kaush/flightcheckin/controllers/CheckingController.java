package com.kaush.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaush.flightcheckin.integration.ReservationRestClient;
import com.kaush.flightcheckin.integration.dtos.Reservation;
import com.kaush.flightcheckin.integration.dtos.ReservationUpdateRequest;

@Controller
public class CheckingController {

	@Autowired
	ReservationRestClient restClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckin";
		
	}
	
	@RequestMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") Long resId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(resId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
		
	}
	
	@RequestMapping("completeReservation")
	public String completeReservation(@RequestParam("reservationId") Long reservationId,@RequestParam("noOfBags") int noOfBags) {
		ReservationUpdateRequest resUpdateRequest = new ReservationUpdateRequest();
		resUpdateRequest.setId(reservationId);
		resUpdateRequest.setNoOfBags(noOfBags);
		resUpdateRequest.setCheckedIn(true);
		restClient.updateReservation(resUpdateRequest);
		return "checkinConfirmation";
	}
}
