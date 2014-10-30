<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="ass1.FlightInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction confirm</title>
</head>
<body>

	<%
	if((Boolean) request.getAttribute("transaction")) {
	%>
		<p>Your purchase is complete!</p>
		<p>Displays all information about the flight</p>
		<p>Display a form for the user to enter passenger details</p>
		<p>Print button to print ticket</p>

	<%
	}
	else {
	%>
		<p>The transaction failed. Display the reason</p>
	<%
	}
	%>
	<form action="./FlightSearch.jsp">
		<input class="ClickButton" type="submit" value="Home">
	</form>

</body>
</html>