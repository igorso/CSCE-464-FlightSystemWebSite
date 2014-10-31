<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<link rel="stylesheet" href="./css/FlightTable.css" type="text/css" />
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
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
<title>View and Book</title>

</head>
<body>
	<jsp:useBean id="selectedFlight" type="beans.DetailedFlightBean"
		scope="session" />

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">Take a look at the selected flight.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						<div class="FlightTable">
							<table>
								<tbody>
									<tr>
										<td><label>Flight number</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="id" /></label></td>
									</tr>
									<tr>
										<td><label>Plane number</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="plane" /></label></td>
									</tr>
									<tr>
										<td><label>Operator</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="operator" /></label></td>
									</tr>
									<tr>
										<td><label>Source</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="source" /></label></td>
									</tr>
									<tr>
										<td><label>Destination</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="destination" /></label></td>
									</tr>
									<tr>
										<td><label>1st class occupied seats:</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="firstClassReserved" /></label></td>
									</tr>
									<tr>
										<td><label>Business class occupied seats:</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="businessReserved" /></label></td>
									</tr>
									<tr>
										<td><label>Economy class occupied seats:</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="economyReserved" /></label></td>
									</tr>
									<tr>
										<td><label>Departure:</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="departure" /></label></td>
									</tr>
									<tr>
										<td><label>Arrival:</label></td>
										<td><label><jsp:getProperty name="selectedFlight"
													property="arrival" /></label></td>
									</tr>
								</tbody>
							</table>
						</div>

						<form action="./ViewAndBook" name="numberOfSeatsForm"
							method="post" onsubmit="return validateNumberOfSeats()">
							<p><label class="field">Choose number of seats:</label> <input class="TextBox" type="number"
								min="1" max="12" name="numberOfSeats"></p>
							<input class="ClickButton" type="submit" value="Check out">
						</form>
						
						<br />

						<form action="./FlightSearch" method="post">
							<input class="ClickButton" type="submit" name="backToFlightResults" value="Back">
						</form>
						
						<br />

						<form action="./FlightSearch.jsp">
							<input class="ClickButton" type="submit" value="Home">
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

<script type="text/javascript">
	function validateNumberOfSeats() {
		var x = document.forms["numberOfSeatsForm"]["numberOfSeats"].value;
		
		if( !isNaN(x) && 
        parseInt(Number(x)) == x && 
        !isNaN(parseInt(x, 10)) ) {
			if(x <= 0) {
				alert("Number of seats has to be greater than zero");
				return false;
			}
		}
		else {
			alert("Input number of seats is not an integer");
			return false;
		}
		
		/*if (x == null || x == "") {
			alert("Source must be filled out");
			return false;
		}
		else if(x <= 0) {
			alert("Number of seats has to be greater than zero");
			return false;
		}
		else if(x !== parseInt(x, 10)) {
			alert("Input number of seats is not an integer");
			return false;
		}*/
		

	}
</script>

</html>