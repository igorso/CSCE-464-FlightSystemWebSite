<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.BookingBean, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
    
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Booking history</title>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">Yours Booking history.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						<div class="col span_1_of_2">
							<div class="FlightTable" id="BookingsTableID">
								<table>
									<thead>
										<tr>
											<td><label>Booking ID</label></td>
											<td><label>Date of booking</label></td>
											<td><label>Flight</label></td>
											<td><label>Number of seats</label></td>
											<td><label>Account ID</label></td>
											<td><label>Cost</label></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="booking" items="${bookingSearch}">
										<tr>
											<td><label>${booking.id}</label></td>
											<td><label>${booking.dateOfBooking}</label></td>
											<td><label>${booking.flightIds}</label></td>
											<td><label>${booking.numberOfSeats}</label></td>
											<td><label>${booking.accountId}</label></td>
											<td><label>${booking.totalCost}</label></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>		
						</div>
						
						<div class="col span_1_of_2">
							<form action="<c:url value='./FlightSearch.jsp' />"> 
								<input class="ClickButton" type="submit" value="Home">
							</form>
						</div>
						
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>