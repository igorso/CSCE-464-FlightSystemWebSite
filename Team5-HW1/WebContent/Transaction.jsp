<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Transaction page</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

	<jsp:useBean id="selectedFlight" type="beans.DetailedFlightBean"
		scope="session" />

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">The details of your flight.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						
						<div class="col span_2_of_3">
							<div class="FlightTable">
								<table>
									<tbody>
										<tr>
											<td><label>Flight number</label></td>
											<td><label><jsp:getProperty name="selectedFlight"
														property="id" /></label></td>
										</tr>
										<tr>
											<td><label>Number of seats:</label></td>
											<td><label><%= request.getAttribute("seats") %></label></td>
										</tr>
										<tr>
											<td><label>Cost:</label></td>
											<td><label><%= request.getAttribute("cost") %></label></td>
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
						</div>
	
						<div class="col span_1_of_3">
							<form action="./TransactionConfirmation" name="bankInfo" method="post" onsubmit="return validateForm()">
								<label class="field">Account:</label><input class="TextBox" type="text" name="accountId"><br>
								<label class="field">Holder:</label><input class="TextBox" type="text" name="holderId"><br>
								<label class="field">Routing:</label><input class="TextBox" type="text" name="routing"><br>
								<input class="ClickButton" type="submit" value="Confirm" align="right">
							</form>
							
							<form action="./FlightSearch.jsp">
								<input class="ClickButton" type="submit" value="Cancel" align="right">
							</form>		
						</div>
	
						<br>
						
					</div>

				</div>
			</div>
		</div>
	</div>

	<script>
		function validateForm() {
			var account = document.forms["bankInfo"]["accountId"].value;
			if(account == null || account == "") {
				alert("Account ID must be filled.");
				return false;
			}
			
			var holder = document.forms["bankInfo"]["holderId"].value;
			if(holder == null || holder == "") {
				alert("Holder ID must be filled.");
				return false;
			}
			
			var routing = document.forms["bankInfo"]["routing"].value;
			if(routing == null || routing == "") {
				alert("Routing number must be filled.");
				return false;
			}
		}
	</script>

	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>