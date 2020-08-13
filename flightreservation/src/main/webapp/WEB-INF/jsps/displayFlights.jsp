<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flights</title>
</head>
<body>
<h3>Flights :</h3>

	<table>
		<thead>
			<tr>
				<td>Airlines</td>
				<td>Departure City</td>
				<td>Arrival City</td>
				<td>Departure Time</td>
			</tr>
		</thead>

		<tbody>
		    <c:forEach items="${flights}" var="flight">
		
			<tr>
				<td>${flight.operatingAirline }</td>
				<td>${flight.departureCity }</td>
				<td>${flight.arrivalCity }</td>
				<td>${flight.estimatedDepartureTime }</td>
				<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>