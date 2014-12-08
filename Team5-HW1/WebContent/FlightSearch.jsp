<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Flight search</title>

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
								<form name="flightSearch" method="post" action="<c:url value='FlightSearch' />"
									onsubmit="return validateForm()">
									
									<p><label class="field">Source:</label> <input class="TextBox" type="text" name="source"
										value="<c:out value="${flightBean.source}" />"></p>
									<p><label class="field">Destination:</label> <input class="TextBox" type="text"
										name="destination"
										value="<c:out value="${flightBean.destination}" />"></p>
									<p><label class="field">Date of travel:</label> <input class="datepicker" type="text" name="date" id="inputdate"
										value="<c:out value="${flightBean.dateOfTravel}" />"></p>
									<p><label class="field">Number of seats:</label> <input class="TextBox" type="text"
										name="nSeats"
										value="<c:out value="${flightBean.numberOfSeats}" />"></p>
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

	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>

</html>