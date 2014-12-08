<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import=" java.util.ArrayList, beans.FlightResultBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
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

							<form action="<c:url value='./FlightResults' />" name="flightSelector" method="post" onsubmit="return atLeastOneRadio()">
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
											<c:forEach var="resultBean" items="${dbResults}">
												<tr>
													<td><label>${resultBean.numberOfFlight}</label></td>
													<td><label>${resultBean.date}</label></td>
													<td><label>${resultBean.departureTime}</label></td>
													<td><label>${resultBean.arrivalTime}</label></td>
													<td><label>${resultBean.numberOfStops}</label></td>
													<td><label>${resultBean.cost}</label>
														<input type="hidden" name="cost" value="${resultBean.cost}"></td>
													<td><input type="radio" name="flightNumber"
														value="${resultBean.numberOfFlight}"></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<input class="ClickButton" type="submit" value="Continue">
							</form>

							<br>
							<form action="<c:url value='./FlightSearch.jsp' />">
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