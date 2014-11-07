<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.BookingBean, java.util.ArrayList"%>
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
							<%
							HttpSession sess = request.getSession();
							ArrayList<BookingBean> bookings = (ArrayList<BookingBean>) sess.getAttribute("bookingSearch");
							int nBookings = bookings.size();
							%>
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
										<%
										for (int i = 0; i < nBookings; ++i) {
											BookingBean booking = bookings.get(i);
										%>
										<tr>
											<td><label><%=booking.getId()%></label></td>
											<td><label><%=booking.getDateOfBooking()%></label></td>
											<td><label><%=booking.getFlightIds()%></label></td>
											<td><label><%=booking.getNumberOfSeats()%></label></td>
											<td><label><%=booking.getAccountId()%></label></td>
											<td><label><%=booking.getTotalCost()%></label>
										</tr>
										<%
										}
										%>
								</table>
							</div>		
						</div>
						
						<div class="col span_1_of_2">
							<form action="./FlightSearch.jsp">
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