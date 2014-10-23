<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight search</title>
<script>
function validateForm() {
    var x = document.forms["flightSearch"]["source"].value;
    if (x==null || x=="") {
        alert("Source must be filled out");
        return false;
    }
    var y = document.forms["flightSearch"]["destination"].value;
    if (y==null || y=="") {
        alert("Destination must be filled out");
        return false;
    }
    var y = document.forms["flightSearch"]["date"].value;
    if (y==null || y=="") {
        alert("Date must be filled out");
        return false;
    }
    var y = document.forms["flightSearch"]["nSeats"].value;
    if (y==null || y=="") {
        alert("The number of seats must be filled out");
        return false;
    }
}
</script>
</head>

<body>
<h1> Flight Search Query Page</h1>
	<form  name="flightSearch" action="./FlightResults.jsp" onsubmit="return validateForm()"> 
		<p> Insert your flight querying data:</p>
		Source:      <input type="text" name="source"><br/>
		Destination: <input type="text" name="destination"><br/>
		Date of travel: <input type="text" name="date"><br/>
		Number of seats: <input type="text" name="nSeats"><br/>
		Class:<select name="class">
				<option value="economy">Economy
				<option value="business">Business
				<option value="first">First
			  </select><br/>
		<input type="submit" value="Submit">
	</form>
</body>
</html>