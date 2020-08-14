<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Details</title>
</head>
<body>

<h2>Flight Details</h2>
<pre>
Flight Number : ${reservation.flight.flightNumber} <br/>
Airline Name : ${reservation.flight.operatingAirline} <br/>
Departure City : ${reservation.flight.departureCity} <br/>
Arrival City : ${reservation.flight.arrivalCity} <br/>
Date of Departure : ${reservation.flight.dateOfDeparture} <br/>
Departure Time : ${reservation.flight.estimatedDepartureTime} <br/>
</pre>
<br/>
<br/>



<h2>Passenger details :</h2><br/>
<pre>
First Name : ${reservation.passenger.firstName} <br/>
Last Name : ${reservation.passenger.lastName} <br/>
Email : ${reservation.passenger.email} <br/>
Phone : ${reservation.passenger.phone} <br/>
</pre>
<br>

<form action="completeReservation" method="post">
<h2>Card details :</h2><br/>
<pre>
Enter the number of bags you want to check in : <input type="text" name="noOfBags"/>
<input type="hidden" name="reservationId" value="${reservation.id}"/>
<input type="submit" value="Check In"/>
</pre>
</form>
</body>
</html>