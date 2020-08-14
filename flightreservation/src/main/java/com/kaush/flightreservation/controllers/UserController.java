package com.kaush.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaush.flightreservation.entities.User;
import com.kaush.flightreservation.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/showReg")
	public String showRegisterPage() {
		LOGGER.info("showRegisterPage method get called..");
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	// public String registerTheUser(@RequestBody User user) {  // meka use karanna ba normal controller eke restcontroller eke nam ok
	public String registerTheUser(@ModelAttribute("user") User user) {
		System.out.println("Register user method get called...");
		userService.saveUser(user);
		return "login/login";
	}
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String userLogin(@RequestParam("email") String email,@RequestParam("password") String password, ModelMap modelMap) {
		LOGGER.info("userLogin method get called..with email"+email);
		
//		LOGGER.error("ERROR");
//		LOGGER.warn("WARN");
//		LOGGER.info("INFO");
//		LOGGER.debug("DEBUG");
//		LOGGER.trace("TRACE"); // this will trace everything goes in our appliation -> most low log level 
		
		User resultUser = userService.findByEmail(email);
		if(resultUser.getPassword().equals(password)) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg" , "User Credentials are invalid");
		}
		return "login/login";
	}
}
