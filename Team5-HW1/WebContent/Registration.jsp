<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<script>
function validateForm() {
    var x = document.forms["Register"]["user"].value;
    if (x==null || x=="") {
        alert("User name must be filled out");
        return false;
    }
    var y = document.forms["Register"]["pwd"].value;
    if (y==null || y=="") {
        alert("Password must be filled out");
        return false;
    }
    var z = document.forms["Register"]["pwd_confirm"].value;
    if (z==null || z=="") {
        alert("Please confirm your password");
        return false;
    }
 
    if (y!=z) {
        alert("The passwords don't match");
        return false;
    }
}
</script>
</head>
<body>
<H1>Welcome to the registration page</H1>
<H2>Please fill out the form</H2>
<form name="Register" action="Registration" method="post" onsubmit="return validateForm()">
Username: <input type="text" name="user">
<br>
Password: <input type="password" name="pwd">
<br>
Confirm: <input type="password" name="pwd_confirm">
<br>
<input type="submit" value="Registration">
</form>
<a href="/Team5-HW1/Login.jsp">Back to login page</a>
</body>
</html>