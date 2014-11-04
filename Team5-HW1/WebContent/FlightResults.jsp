<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="ass1.RandomFlights, java.util.ArrayList, beans.FlightResultBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/FlightTable.css" type="text/css" />
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
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

<title>Flight results</title>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">The results of your query.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						
							<%
								int nFlights = (Integer) request.getAttribute("numberOfResults");
								ArrayList<FlightResultBean> dbResults = (ArrayList<FlightResultBean>) request
										.getAttribute("dbResults");
							%>
							<form action="./FlightResults" method="post">
								<div class="FlightTable" id="flightResultsTable">
									<table>
										<thead>
											<tr>
												<td><label>Flight</label></td>
												<td><label>Date</label></td>
												<td><label>Departure time</label></td>
												<td><label>Arrival time</label></td>
												<td><label>Number of stops</label></td>
												<td><label>Costs</label></td>
												<td><label>View and Book</label></td>
											</tr>
										</thead>
										<tbody>
											<%
												for (int i = 0; i < nFlights; ++i) {
													FlightResultBean fInfo = dbResults.get(i);
											%>
											<tr>
												<td><label><%=fInfo.getNumberOfFlight()%></label></td>
												<td><label><%=fInfo.getDate()%></label></td>
												<td><label><%=fInfo.getDepartureTime()%></label></td>
												<td><label><%=fInfo.getArrivalTime()%></label></td>
												<td><label><%=fInfo.getNumberOfStops()%></label></td>
												<td><label><%=String.format("%.2f", fInfo.getCost())%></label>
													<input type="hidden" name="cost" value=<%=fInfo.getCost()%>></td>
												<td><input type="radio" name="flightNumber"
													value=<%=fInfo.getNumberOfFlight()%>></td>
											</tr>
											<%
												}
											%>
										
									</table>
								</div>
								<input class="ClickButton" type="submit" value="Continue">
							</form>

							<br>
							<form action="./FlightSearch.jsp">
								<input class="ClickButton" type="submit" value="Back">
							</form>

						
						
						
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