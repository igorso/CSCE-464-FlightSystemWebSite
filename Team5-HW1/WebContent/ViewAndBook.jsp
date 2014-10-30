<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<link rel="stylesheet" href="./css/FlightTable.css" type="text/css" />
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and Book</title>
</head>
<body>

	<h1>Take a look at the selected flight</h1>

	<jsp:useBean id="selectedFlight" type="beans.DetailedFlightBean"
		scope="session" />
	<div class="FlightTable">
		<table>
			<tbody>
				<tr>
					<td><label>Flight number</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="id" /></label></td>
				</tr>
				<tr>
					<td><label>Plane number</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="plane" /></label></td>
				</tr>
				<tr>
					<td><label>Operator</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="operator" /></label></td>
				</tr>
				<tr>
					<td><label>Source</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="source" /></label></td>
				</tr>
				<tr>
					<td><label>Destination</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="destination" /></label></td>
				</tr>
				<tr>
					<td><label>1st class occupied seats:</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="firstClassReserved" /></label></td>
				</tr>
				<tr>
					<td><label>Business class occupied seats:</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="businessReserved" /></label></td>
				</tr>
				<tr>
					<td><label>Economy class occupied seats:</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="economyReserved" /></label></td>
				</tr>
				<tr>
					<td><label>Departure:</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="departure" /></label></td>
				</tr>
				<tr>
					<td><label>Arrival:</label></td>
					<td><label><jsp:getProperty name="selectedFlight" property="arrival" /></label></td>
				</tr>					
			</tbody>
		</table>
	</div>

	<form action="./ViewAndBook" name="numberOfSeatsForm" method="post" onsubmit="return validateNumberOfSeats()">
		Choose number of seats: <input class="TextBox" type="text" name="numberOfSeats"><br>
		<input class="ClickButton" type="submit" value="Check out">
	</form>
	<br />

	<form action="./FlightSearch" method="post">
		<input class="ClickButton" type="submit" name="backToFlightResults"
			value="Back">
	</form>
	<br />

	<form action="./FlightSearch.jsp">
		<input class="ClickButton" type="submit" value="Home">
	</form>

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