<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Registration</title>


</head>
<body>
	
	<header>
		<p class="introtext">Welcome to the registration page!</p>
		<H5>Please fill out the form. Attention to input a valid email.</H5>
	</header>
	
	<div class="section group">
		<div class="col span_1_of_3">
		</div>
		
		<div class="col span_1_of_3">
			<form name="Register" action="Registration" method="post"
				onsubmit="return validateForm()">
				<p><label class="field">Email:</label> <input class="TextBox" type="text" name="user"></p>
				<p><label class="field">Full name:</label> <input class="TextBox" type="text" name="fullname"></p>
				<p><label class="field">Organization name</label> <input class="TextBox" type="text" name="name"></p>
				<p><label class="field">Organization adress</label> <input class="TextBox" type="text" name="adress"></p>
				<p><label class="field">Password:</label> <input class="TextBox" type="password" name="pwd"> </p>
				<p><label class="field">Confirm:</label> <input class="TextBox"	type="password" name="pwd_confirm"> </p>
				<p><input class="ClickButton" type="submit" value="Registration"></p>
			</form>
			<a href="/Team5-HW3-AirlineReservation/Login.jsp">Back to login page</a>
		</div>
		
		<div class="col span_1_of_3">
		</div>
		
	</div>
	
	<script>
		function validateForm() {
			var x = document.forms["Register"]["user"].value;
			if (x == null || x == "") {
				alert("Email must be filled out");
				return false;
			}
			if(!isEmailAddress(x)) {
				alert("Email must be a valid email address");
				return false;
			}
			var y = document.forms["Register"]["pwd"].value;
			if (y == null || y == "") {
				alert("Password must be filled out");
				return false;
			}
			var z = document.forms["Register"]["pwd_confirm"].value;
			if (z == null || z == "") {
				alert("Please confirm your password");
				return false;
			}
	
			if (y != z) {
				alert("The passwords don't match");
				return false;
			}
		}
		
		function isEmailAddress(str) {
			var pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
		    return str.match(pattern);    
	
		}
	</script>
	
	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>