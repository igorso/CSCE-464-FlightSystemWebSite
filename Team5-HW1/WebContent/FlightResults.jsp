<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="ass1.RandomFlights, java.util.ArrayList, beans.FlightResultBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/FlightTable.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight results</title>
</head>
<body>

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
						<td><label><%=String.format("%.2f", fInfo.getCost())%></label></td>
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

	<br><form action="./FlightSearch.jsp">
		<input class="ClickButton" type="submit" value="Back">
	</form>

</body>
</html>