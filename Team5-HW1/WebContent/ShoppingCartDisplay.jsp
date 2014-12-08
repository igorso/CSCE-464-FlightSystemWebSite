<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import=" java.util.ArrayList, beans.DetailedFlightBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 

<c:choose>
	<c:when test="${ not empty shoppingCart }">

		<div class="FlightTable">
			<table>
				<thead>
					<tr>
						<td><label>Flight</label></td>
						<td><label>Plane</label></td>
						<td><label>Departure time</label></td>
						<td><label>Number Of seats</label></td>
						<td><label>Total Cost</label></td>
						<td><label>Cost per seat</label></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="flight" items="${ shoppingCart }">
						<tr>
							<td><label>${flight.id}</label></td>
							<td><label>${flight.plane}</label></td>
							<td><label>${flight.departure}</label></td>
							<td><label>${flight.numberOfSeat}</label></td>
							<td><label>${flight.totalCost}</label></td>
							<td><label>${flight.cost}</label>
						</tr>
					</c:forEach>
			</table>
		</div>
	</c:when>
	
	<c:otherwise>
		<h3>The shopping cart is empty</h3>
	</c:otherwise>

</c:choose>
							