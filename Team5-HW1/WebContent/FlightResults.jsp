<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ass1.RandomFlights, java.util.ArrayList, beans.FlightResultBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight results</title>
</head>
<body>

<%
int nFlights = (Integer) request.getAttribute("numberOfResults");
ArrayList<FlightResultBean> dbResults = (ArrayList<FlightResultBean>) request.getAttribute("dbResults");
for(int i = 0; i < nFlights; ++i) {
	FlightResultBean fInfo = dbResults.get(i); %>
	<fieldset>
		<legend>Flight <%= fInfo.getNumberOfFlight() %></legend>
		Date: <%= fInfo.getDate()%><br/>
		Departure time: <%= fInfo.getDepartureTime() %><br/>
		Arrival time: <%= fInfo.getArrivalTime() %><br/>
		Number of stops: <%= fInfo.getNumberOfStops() %><br/>
		Cost: $ <%= String.format("%.2f", fInfo.getCost()) %><br/>
		<form action="./ViewAndBook.jsp">
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