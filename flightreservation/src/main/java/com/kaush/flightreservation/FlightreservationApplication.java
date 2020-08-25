package com.kaush.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FlightreservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}



// setup to make war file works
/*
 * @SpringBootApplication
	public class FlightreservationApplication extends SpringBootServletInitializer {
 * 		// then override configure method with 
 * 
 * 	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
	return builder.sources(FlightreservationApplication.class);
	}
 * 
 */
	
	
}
