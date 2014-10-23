<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ass1.FlightInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and Book</title>
</head>
<body>

Here is more info about your flight terms and conditions:
(Next assignment will be persistent data across JSP pages here)

	<form action="./TransactionPage.jsp">
		<%
			session.setAttribute("fInfo", session.getAttribute("fInfo"));
		%>
		<input type="submit" value="Check out">
	</form><br/>

	<form action="./FlightResults.jsp">
    	<input type="submit" value="Back">
	</form><br/>

	<form action="./FlightSearch.jsp">
    	<input type="submit" value="Home">
	</form>

</body>
</html>