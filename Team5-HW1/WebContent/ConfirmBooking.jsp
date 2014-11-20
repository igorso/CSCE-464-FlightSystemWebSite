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
	if (validateForm()==false)
	{
	return false;
	}
	var accountId = $("#accountId").val();
	var holderId = $("#holderId").val();
	var routing = $("#routing").val();
	//alert("We will ask the bank")
    $.get("Bank", {accountId:accountId,holderId:holderId,routing:routing}, function(data,status,xhr){
    	//alert("Bank finished to work");
    	//alert(data);
    	 var response = data.split('#');
    	//alert(response[0]);
    	//alert(response[1]);

    	$("#bResults").html(response[1]);
    	if(response[0]=="Work")
    	{
    		//alert("It worked");
    		updateDB();
    		$("#payement").hide();
    		$("#backSC").hide();
    	}else
 		{
    		//alert("It didnt work");
 		}
		},"text");  
}

function updateDB()
{
	var accountId = $("#accountId").val();
    $.get("UpdateBooking", {accountId:accountId}, function(data,status,xhr){
    	var response = data.split('#');
    	//alert(response[0]);
    	

    	$("#DBResults").html(response[1]);
    	if(response[0]=="Work")
    	{
    		//alert("It worked");
    		$("#infoForm").show();
    	
    	}else
 		{
    		alert(response[1]);
 		}
		},"text");  
}


function printTicket()
{  
	window.print();
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
							<jsp:include page="ShoppingCartDisplay.jsp"></jsp:include>
						</div>
	
						<div class="col span_1_of_3" >
							<div id="infoForm" style="display: none;">
								<form name="flightSearch" method="post" action="FlightSearch" >				
									<p><label class="field">Name:</label> <input class="TextBox" type="text" name="name"></p>
									<p><label class="field">Sex:</label> <input class="TextBox" type="text" name="Sex"></p>
									<p><label class="field">Age:</label> <input class="TextBox" type="text" name="Age"></p>	
								</form>
								<a id="myLink" href="./PrinterPDF" target="_blank">Print PDF (does not work)</a>
								<form action="./FlightSearch.jsp">
									<button onclick="printTicket()">Print tickets</button>
	
								</form>
								<form action="./ClearShoppingCart">
								<input class="ClickButton" type="submit" value="New Flights" align="right">
								</form>	
							</div>
							<form action="./TransactionConfirmation" name="bankInfo" method="post" id="payement" onsubmit="return validateForm()">
								<label class="field" >Account:</label><input class="TextBox" type="text" id="accountId" ><br>
								<label class="field" >Holder:</label><input class="TextBox" type="text" id="holderId"><br>
								<label class="field" >Routing:</label><input class="TextBox" type="text" id="routing"><br>
								<input class="ClickButton"  type="button" value="Pay" onClick="askBank()">
								
							</form>
							<p id="bResults"></p>
							<p id="DBResults"></p>
							
							
							<div id="backSC">
								<form action="./ShoppingCart.jsp">
									<input class="ClickButton" type="submit" value="Back to shopping cart" align="right">
								</form>	
							</div>
							
							
								
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
