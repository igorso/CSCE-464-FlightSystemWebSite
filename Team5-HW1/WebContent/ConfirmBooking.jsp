<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
function askBank()
{
	
	var accountId = $("#accountId").val();
	var holderId = $("#holderId").val();
	var routing = $("#routing").val();
	alert("We will ask the bank")
    $.get("Bank", {accountId:accountId,holderId:holderId,routing:routing}, function(data,status){
    	alert("Bank finished to work");
    	//$("#results").html("Added to the shopping cart");
    	//$("#add").hide();// We hide the button so the user can not add several times the same flight.
		});  
}
</script>
<title>Booking Confirm</title>
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
								TO DO DISPLAY LIKE THE SHOPPING CART
							</div>
						</div>
	
						<div class="col span_1_of_3">
							<form action="./TransactionConfirmation" name="bankInfo" method="post" onsubmit="return validateForm()">
								<label class="field" >Account:</label><input class="TextBox" type="text" id="accountId" ><br>
								<label class="field" >Holder:</label><input class="TextBox" type="text" id="holderId"><br>
								<label class="field" >Routing:</label><input class="TextBox" type="text" id="routing"><br>
								<input class="ClickButton"  type="button" value="Pay" onClick="askBank()">
							</form>
							<form action="./UpdateBooking">
							TO DO HIDE THIS until the bank confirm (and replace by a form...)
							What to do if the bank does not confirm?
								<input class="ClickButton" type="submit" value="Finish" align="right">
							</form>		
							
							
							<form action="./ShoppingCart.jsp">
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