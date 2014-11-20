<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Transaction confirm</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

	<%
	if((Boolean) request.getAttribute("transaction")) {
	%>
		
		<jsp:useBean id="selectedFlight" type="beans.DetailedFlightBean"
			scope="session" />
	
		<div id="wrapper">
			<div id="headcontainer">
				<header>
				<p class="introtext">Your purchase is complete!</p>
				</header>
	
			</div>
			<div id="maincontentcontainer">
				<div class="standardcontainer" id="example">
					<div class="maincontent">
	
						<div class="section group">
							
							<div class="col span_2_of_3">
								<div class="FlightTable">
									TO DO SHOW THE SHOPPING CART
								</div>
							</div>
		
							<div class="col span_1_of_3">
								<p>Show fields to passenger fulfill with their information</p>
								<a id="myLink" href="./PrinterPDF" target="_blank">Print PDF</a>
								<form action="./FlightSearch.jsp">
									<input class="ClickButton" type="submit" value="Home">
								</form>
										
							</div>
		
							<br>
							
						</div>
	
					</div>
				</div>
			</div>
		</div>

	<%
	}
	else {
	%>
		<div class="section group">
			<p><%= request.getAttribute("errorMessage") %></p>
			<form action="./FlightSearch.jsp">
				<input class="ClickButton" type="submit" value="Home">
			</form>
		</div>
	<%
	}
	%>
	

	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>