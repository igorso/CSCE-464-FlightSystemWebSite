<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ass1.RandomFlights, ass1.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight results</title>
</head>
<body>

<%
int nFlights = 3;
RandomFlights randomFlights = new RandomFlights(nFlights);
for(int i = 0; i < nFlights; ++i) {
	FlightInfo fInfo = randomFlights.getFlight(i); %>
	<fieldset>
		<legend>Flight <%= i %></legend>
		Departure time: <%= fInfo.getDepartureTime() %><br/>
		Arrival time: <%= fInfo.getArrivalTime() %><br/>
		Number of stops: <%= fInfo.getnStops() %><br/>
		Cost: $ <%= String.format("%.2f", fInfo.getCost()) %><br/>
		<form action="./ViewAndBook.jsp">
			<%session.setAttribute("fInfo", randomFlights.getFlight(i));%>
			<input type="submit" value="View">
		</form>
	</fieldset>
	<br />
<%} %>

<form action="./FlightSearch.jsp">
    <input type="submit" value="Back">
</form>

</body>
</html>