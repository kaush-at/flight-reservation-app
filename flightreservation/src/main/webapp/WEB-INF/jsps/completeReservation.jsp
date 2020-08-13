<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Completed Reservation</title>
</head>
<body>

<h2>Complete Reservation</h2>
Flight Number : ${flightInfo.flightNumber} <br/>
Airline Name : ${flightInfo.operatingAirline} <br/>
Departure City : ${flightInfo.departureCity} <br/>
Arrival City : ${flightInfo.arrivalCity} <br/>
Date of Departure : ${flightInfo.dateOfDeparture} <br/>
Departure Time : ${flightInfo.estimatedDepartureTime} <br/>

<br/>
<br/>

<form action="completeReservation" method="post">
<pre>
<h2>Passenger details :</h2><br/>
First Name : <input type="text" name="passengerFirstName"/><br/>
Last Name : <input type="text" name="passengerLastName"/><br/>
Email : <input type="text" name="passengerEmail"/><br/>
Phone : <input type="text" name="passengerPhone"/><br/>
<br>

<h2>Card details :</h2><br/>
Name on the card : <input type="text" name="nameOntheCard"/><br/>
Card Number : <input type="text" name="cardNumber"/><br/>
Expire Date : <input type="text" name="expireDate"/><br/>
CVV Number : <input type="text" name="cvv"/><br/>

<input type="hidden" name="flightId" value="${flightInfo.id}"/>
<input type="submit" value="Confirm"/>
</pre>
</form>
</body>
</html>