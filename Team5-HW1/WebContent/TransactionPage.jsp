<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ass1.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction page</title>
</head>
<body>

Just press confirm to finish your transaction. Next Assignment will be more informationa about the flight here.

<form action="./TransactionConfirmation.jsp">
	<input type="submit" value="Confirm">
</form>

<form action="./FlightSearch.jsp">
	<input type="submit" value="Cancel">
</form>

</body>
</html>