<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
function updateCart()
{
	if(validateNumberOfSeats()) {
		var numberSeats = $("#numberSeats").val();
		
	    $.get("UpdateShoppingCart", {numberSeats:numberSeats}, function(data,status){
	    
	    	$("#results").html("Added to the shopping cart");
	    	$("#add").hide();// We hide the button so the user can not add several times the same flight.
			});
	}
  
}
</script>

<title>View and Book</title>

</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<jsp:useBean id="selectedFlight" type="beans.DetailedFlightBean"
		scope="session" />

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">Take a look at the selected flight.</p>
			</header>
		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						<h3 align="center" id="results"> Select the number of seats and add to the shopping cart.</h3>
					</div>

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
							<form action="./ViewAndBook" name="numberOfSeatsForm"
								method="post">
								<p><label class="field">Choose number of seats:</label> <input class="TextBox" type="number"
									min="1" max="12" name="numberOfSeats" id="numberSeats"></p>
								<input class="ClickButton" id="add" type="button" value="Add to shopping cart" onClick="updateCart()">
							</form>
							
							<br />
	
							<form action="./FlightSearch" method="post">
								<input class="ClickButton" type="submit" name="backToFlightResults" value="Back">
							</form>
							
							<br />
	
							<form action="./ShoppingCart.jsp">
								<input class="ClickButton" type="submit" value="Go to the shopping cart">
							</form>
							
							<br />
	
							<form action="./FlightSearch.jsp">
								<input class="ClickButton" type="submit" value="Home">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


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
			return true;
		}
	</script>

	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>

</html>