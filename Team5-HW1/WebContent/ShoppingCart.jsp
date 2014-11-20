<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import=" java.util.ArrayList, beans.DetailedFlightBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Shopping Cart</title>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">The results of the shopping cart:</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						
							<jsp:include page="ShoppingCartDisplay.jsp"></jsp:include>
								
							<form action="./ViewAndBook" name="flightSelector" method="post">
								<input class="ClickButton" type="submit" value="Check out">
							</form>

							<br>
							
							<form action="./FlightSearch.jsp">
								<input class="ClickButton" type="submit" value="Continue shopping">
							</form>

					</div>

				</div>
			</div>
		</div>
	</div>


	
	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>