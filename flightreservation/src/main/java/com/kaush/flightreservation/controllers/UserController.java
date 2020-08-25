package com.kaush.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaush.flightreservation.entities.User;
import com.kaush.flightreservation.services.SecurityService;
import com.kaush.flightreservation.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/showReg")
	public String showRegisterPage() {
		LOGGER.info("showRegisterPage method get called..");
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registerTheUser(@ModelAttribute("user") User user) {
		LOGGER.info("Register user method get called...");
		user.setPassword(encoder.encode(user.getPassword()));
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
		
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return "findFlights";
		}else {
			modelMap.addAttribute("msg" , "User Credentials are invalid");
		}
		return "login/login";
	}
}
