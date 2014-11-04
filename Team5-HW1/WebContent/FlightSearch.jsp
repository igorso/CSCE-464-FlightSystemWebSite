<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<link rel="stylesheet" href="./css/LabelField.css" type="text/css">

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


<link rel="stylesheet" href="./pickdateLib/themes/default.css" id="theme_base">
<link rel="stylesheet" href="./pickdateLib/themes/default.date.css" id="theme_date">
<link rel="stylesheet" href="./pickdateLib/themes/default.time.css" id="theme_time">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="./pickdateLib/picker.js"></script>
<script src="./pickdateLib/picker.date.js"></script>
<script src="./pickdateLib/picker.time.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight search</title>
<script>
	function validateForm() {
		var x = document.forms["flightSearch"]["source"].value;
		if (x == null || x == "") {
			alert("Source must be filled out");
			return false;
		}
		var y = document.forms["flightSearch"]["destination"].value;
		if (y == null || y == "") {
			alert("Destination must be filled out");
			return false;
		}
		var y = document.forms["flightSearch"]["date"].value;
		if (y == null || y == "") {
			alert("Date must be filled out");
			return false;
		}
		var y = document.forms["flightSearch"]["nSeats"].value;
		if (y == null || y == "") {
			alert("The number of seats must be filled out");
			return false;
		}
	}
</script>

<script>
$(document).ready(function(){

    $("input.datepicker").click(function(){

    	//alert( "Handler for .click() called." );
        $('.datepicker').pickadate();  

    });
}); //this was missing
</script> 


</head>

<jsp:useBean id="flightBean" class="beans.FlightSearchBean"
	scope="session" />

<body>

<jsp:include page="Header.jsp"></jsp:include>

<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">Flight Search Query Page.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						<h3 align="center">Insert your flight querying data.</h3>
					</div>

					<div class="section group">
						
						<div class="col span_1_of_3">
						</div>
						
						<div class="col span_1_of_3">
							<div>
								<form name="flightSearch" method="post" action="FlightSearch"
									onsubmit="return validateForm()">
									
									<p><label class="field">Source:</label> <input class="TextBox" type="text" name="source"
										value=<jsp:getProperty property="source" name="flightBean"/>></p>
									<p><label class="field">Destination:</label> <input class="TextBox" type="text"
										name="destination"
										value=<jsp:getProperty property="destination" name="flightBean"/>></p>
									<p><label class="field">Date of travel:</label> <input class="datepicker" type="text" name="date" id="inputdate"
										value=<jsp:getProperty property="dateOfTravel" name="flightBean"/>></p>
									<p><label class="field">Number of seats:</label> <input class="TextBox" type="text"
										name="nSeats"
										value=<jsp:getProperty property="numberOfSeats" name="flightBean"/>></p>
									<p><label class="field">Class:</label> <select class="TextBox" name="flightClass">
										<option value="economy">Economy
										<option value="business">Business
										<option value="first">First </select></p>
									<input class="ClickButton" type="submit" name="flightSearchSubmit" value="Submit" align="right">
								</form>
							</div>
						</div>
						
						<div class="col span_1_of_3">
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