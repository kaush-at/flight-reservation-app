package com.kaush.flightreservation.services;

import com.kaush.flightreservation.entities.User;

public interface UserService {
	
	public User saveUser(User user);

	public User findByEmail(String email);
	
	

}
