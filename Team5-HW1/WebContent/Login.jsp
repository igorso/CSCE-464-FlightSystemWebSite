<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="./css/TextBox.css" type="text/css" />
<link rel="stylesheet" href="./css/ClickButton.css" type="text/css" />
<link rel="stylesheet" href="./css/LabelField.css" type="text/css">

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

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">Welcome in our flight reservation website.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						<h3 align="center">Please log in.</h3>
					</div>

					<div class="section group">
						
						<div class="col span_1_of_3">
						</div>
						
						<div class="col span_1_of_3">
							<div>
								<form name="Login" action="Login" method="post"
									onsubmit="return validateForm()">
									<p><label class="field">Email:</label> <input class="TextBox" type="text" name="user"></p>
									<p><label class="field">Password:</label> <input class="TextBox" type="password" name="pwd">
									<input class="ClickButton" type="submit" value="Login" align="right"></p>
								</form>
								<a href="/Team5-HW1/Registration.jsp">New user: Please register</a>
							</div>
						</div>
						
						<div class="col span_1_of_3">
						</div>
						
					</div>

				</div>
			</div>
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