<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  import="beans.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Login</title>

</head>
<jsp:useBean id="userBean" class="beans.UserBean"
	scope="session" />
	
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
									<p><label class="field">Email:</label> <input class="TextBox" type="text" name="user" 
									value=<jsp:getProperty property="email" name="userBean"/>></p>
									<p><label class="field">Password:</label> <input class="TextBox" type="password" name="pwd">
									<input class="ClickButton" type="submit" value="Login" align="right"
									value=<jsp:getProperty property="password" name="userBean"/>></p>
								</form>
								<a href="/Team5-HW2/Registration.jsp">New user: Please register</a>
							</div>
						</div>
						
						<div class="col span_1_of_3">
						</div>
						
					</div>

				</div>
			</div>
		</div>
	</div>

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

	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>
	
</body>
</html>