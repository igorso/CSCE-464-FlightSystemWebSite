<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
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
</head>

<jsp:useBean id="flightBean" class="beans.FlightSearchBean"
	scope="session" />

<body>
	<h1>Flight Search Query Page</h1>
	<form name="flightSearch" method="post" action="FlightSearch"
		onsubmit="return validateForm()">
		<p>Insert your flight querying data:</p>
		Source: <input class="TextBox" type="text" name="source"
			value=<jsp:getProperty property="source" name="flightBean"/>><br />
		Destination: <input class="TextBox" type="text" name="destination"
			value=<jsp:getProperty property="destination" name="flightBean"/>><br />
		Date of travel: <input class="TextBox" type="text" name="date"
			value=<jsp:getProperty property="dateOfTravel" name="flightBean"/>><br />
		Number of seats: <input class="TextBox" type="text" name="nSeats"
			value=<jsp:getProperty property="numberOfSeats" name="flightBean"/>><br />
		Class:<select class="TextBox" name="flightClass">
			<option value="economy">Economy
			<option value="business">Business
			<option value="first">First
		</select><br /> <input class="ClickButton" type="submit" name="flightSearchSubmit" value="Submit">
	</form>
</body>

</html>