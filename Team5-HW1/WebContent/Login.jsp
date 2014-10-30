<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<script>
	function validateForm() {
		var x = document.forms["Login"]["user"].value;
		if (x == null || x == "") {
			alert("User name must be filled out");
			return false;
		}
		var y = document.forms["Login"]["pwd"].value;
		if (y == null || y == "") {
			alert("Password must be filled out");
			return false;
		}
	}
</script>

</head>
<body>
	<div align="center">
		<H1>Welcome in our flight reservation website</H1>
		<H2>Please log in</H2>
		<form name="Login" action="Login" method="post"
			onsubmit="return validateForm()">
			<label>Username:</label> <input class="TextBox" type="text"
				name="user"><br> <label>Password:</label> <input
				class="TextBox" type="password" name="pwd"><br> <input
				class="ClickButton" type="submit" value="Login">
		</form>
		<a href="/Team5-HW1/Registration.jsp">New user: Please register</a>
	</div>
</body>
</html>