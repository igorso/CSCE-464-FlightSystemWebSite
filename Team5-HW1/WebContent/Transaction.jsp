<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Transaction page</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">The details of your flight.</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						
						<div class="col span_2_of_3">
							<div class="FlightTable">
								<table>
									<tbody>
										<tr>
											<td><label>Flight number</label></td>
											<td><label><c:out value="${selectedFlight.id}" /></label></td>
										</tr>
										<tr>
											<td><label>Number of seats:</label></td>
											<td><label><c:out value="${seats}" /></label></td>
										</tr>
										<tr>
											<td><label>Cost:</label></td>
											<td><label><c:out value="${cost}}" /></label></td>
										</tr>
										<tr>
											<td><label>Plane number</label></td>
											<td><label><c:out value="${selectedFlight.plane}" /></label></td>
										</tr>
										<tr>
											<td><label>Operator</label></td>
											<td><label><c:out value="${selectedFlight.operator}" /></label></td>
										</tr>
										<tr>
											<td><label>Source</label></td>
											<td><label><c:out value="${selectedFlight.source}" /></label></td>
										</tr>
										<tr>
											<td><label>Destination</label></td>
											<td><label><c:out value="${selectedFlight.destination}" /></label></td>
										</tr>
										<tr>
											<td><label>Departure:</label></td>
											<td><label><c:out value="${selectedFlight.departure}" /></label></td>
										</tr>
										<tr>
											<td><label>Arrival:</label></td>
											<td><label><c:out value="${selectedFlight.arrival}" /></label></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
	
						<div class="col span_1_of_3">
							<form action="<c:url value='./TransactionConfirmation' />" name="bankInfo" method="post" onsubmit="return validateForm()">
								<label class="field">Account:</label><input class="TextBox" type="text" name="accountId"><br>
								<label class="field">Hvcwgdsgdfhgfxgr:</label><input class="TextBox" type="text" name="holderId"><br>
								<label class="field">Routing:</label><input class="TextBox" type="text" name="routing"><br>
								<input class="ClickButton" type="submit" value="Confirm" align="right">
							</form>
							
							<form action="<c:url value='./FlightSearch.jsp' />">
								<input class="ClickButton" type="submit" value="Cancel" align="right">
							</form>		
						</div>
	
						<br>
						
					</div>

				</div>
			</div>
		</div>
	</div>

	<script>
		function validateForm() {
			var account = document.forms["bankInfo"]["accountId"].value;
			if(account == null || account == "") {
				alert("Account ID must be filled.");
				return false;
			}
			
			var holder = document.forms["bankInfo"]["holderId"].value;
			if(holder == null || holder == "") {
				alert("Holder ID must be filled.");
				return false;
			}
			
			var routing = document.forms["bankInfo"]["routing"].value;
			if(routing == null || routing == "") {
				alert("Routing number must be filled.");
				return false;
			}
		}
	</script>

	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>