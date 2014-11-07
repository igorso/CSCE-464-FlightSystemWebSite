<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import=" java.util.ArrayList, beans.FlightResultBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

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
							<form action="./FlightResults" name="flightSelector" method="post" onsubmit="return atLeastOneRadio()">
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
												<td><label><%=fInfo.getCost()%></label>
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

	<script>
	function atLeastOneRadio() {
	    var isChecked = $('input[type=radio]:checked').size() > 0;
		if (!isChecked) {
	    	alert("You must select a flight.");
	    	return isChecked;
	    }
	}
	</script>
	
	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>