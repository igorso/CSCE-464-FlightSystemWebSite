<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/LabelField.css" type="text/css">
<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />

	<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="cleartype" content="on">

	<link rel="stylesheet" href="./responsivegridsystem/css/html5reset.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/responsivegridsystem.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/col.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/2cols.css" media="all">
	<link rel="stylesheet" href="./responsivegridsystem/css/3cols.css" media="all">

	
	<link rel="stylesheet" media="only screen and (max-width: 1024px) and (min-width: 769px)" href="./responsivegridsystem/css/1024.css">
	<link rel="stylesheet" media="only screen and (max-width: 768px) and (min-width: 481px)" href="./responsivegridsystem/css/768.css">
	<link rel="stylesheet" media="only screen and (max-width: 480px)" href="./responsivegridsystem/css/480.css">
	
	<!-- All JavaScript at the bottom, except for Modernizr which enables HTML5 elements and feature detects -->
	<script src="./responsivegridsystem/js/modernizr-2.5.3-min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration</title>

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
				<p><label class="field">Password:</label> <input class="TextBox" type="password" name="pwd"> </p>
				<p><label class="field">Confirm:</label> <input class="TextBox"	type="password" name="pwd_confirm"> </p>
				<p><input class="ClickButton" type="submit" value="Registration"></p>
			</form>
			<a href="/Team5-HW1/Login.jsp">Back to login page</a>
		</div>
		
		<div class="col span_1_of_3">
		</div>
		
	</div>
	
	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if necessary -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="./responsivegridsystem/js/jquery-1.7.2.min.js"><\/script>')</script>

	<!--[if (lt IE 9) & (!IEMobile)]>
	<script src="js/selectivizr-min.js"></script>
	<![endif]-->

	<!-- More Scripts-->
	<script src="./responsivegridsystem/js/responsivegridsystem.js"></script>

</body>
</html>