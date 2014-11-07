<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="beans.BookingBean, java.util.ArrayList"%>
<html>
<head>
<link rel="stylesheet" href="./css/FlightTable.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />

	<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="cleartype" content="on">

	<link rel="stylesheet" href="./responsivegridsystem/css/html5reset.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/responsivegridsystem.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/col.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/2cols.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/3cols.css" media="all">

	
	<link rel="stylesheet" media="only screen and (max-width: 1024px) and (min-width: 769px)" href="./responsivegridsystem/css/1024.css">
	<link rel="stylesheet" media="only screen and (max-width: 768px) and (min-width: 481px)" href="./responsivegridsystem/css/768.css">
	<link rel="stylesheet" media="only screen and (max-width: 480px)" href="./responsivegridsystem/css/480.css">
	
	<!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements and feature detects -->
	<script src="./responsivegridsystem/js/modernizr-2.5.3-min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
							ArrayList<BookingBean> bookings = (ArrayList<BookingBean>) request.getAttribute("bookings");
							int nBookings = bookings.size();
							%>
							<div class="BookingsTable" id="BookingsTableID">
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
	
	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if necessary -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="./responsivegridsystem/js/jquery-1.7.2.min.js"><\/script>')</script>

	<!--[if (lt IE 9) & (!IEMobile)]>
	<script src="js/selectivizr-min.js"></script>
	<![endif]-->

	<!-- More Scripts-->
	<script src="./responsivegridsystem/js/responsivegridsystem.js"></script>

</body>
</html>