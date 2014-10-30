<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="ass1.FlightInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction page</title>
</head>
<body>

	<p>Show same details as the ViewAndBook.jsp</p>
	<p>Number of seats: <%= request.getAttribute("seats") %></p>
	<p>Cost: <%= request.getAttribute("cost") %></p>
	
	<form action="./TransactionConfirmation" method="post">
		<label>Account:</label><input class="TextBox" type="text" name="accountId"><br>
		<label>Holder:</label><input class="TextBox" type="text" name="holderId"><br>
		<label>Routing:</label><input class="TextBox" type="text" name="routing"><br>
		<input class="ClickButton" type="submit" value="Confirm">
	</form>
	
	<br>
	
	<form action="./FlightSearch.jsp">
		<input class="ClickButton" type="submit" value="Cancel">
	</form>

</body>
</html>