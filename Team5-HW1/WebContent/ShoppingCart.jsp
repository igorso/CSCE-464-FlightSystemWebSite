<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import=" java.util.ArrayList, beans.DetailedFlightBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<jsp:include page="CssAndExternalLibrary.jsp"></jsp:include>

<title>Shopping Cart</title>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="headcontainer">
			<header>
			<p class="introtext">The results of the shopping cart:</p>
			</header>

		</div>
		<div id="maincontentcontainer">
			<div class="standardcontainer" id="example">
				<div class="maincontent">

					<div class="section group">
						
							<%
							if(request.getSession(false).getAttribute("shoppingCart") != null) {
							ArrayList<DetailedFlightBean> shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
							%>
							<form action="./ViewAndBook" name="flightSelector" method="post">
								<div class="FlightTable" id="flightResultsTable">
									<table>
										<thead>
											<tr>
												<td><label>Flight</label></td>
												<td><label>Plane</label></td>
												<td><label>Departure time</label></td>
												<td><label>Number Of seats</label></td>
												<td><label>Total Cost</label></td>
												<td><label>Cost per seat</label></td>
											</tr>
										</thead>
										<tbody>
											<%
											for (DetailedFlightBean fInfo : shoppingCart) {					
											%>
											<tr>
												<td><label><%=fInfo.getId()%></label></td>
												<td><label><%=fInfo.getPlane()%></label></td>
												<td><label><%=fInfo.getDeparture()%></label></td>
												<td><label><%=fInfo.getNumberOfSeat()%></label></td>
												<td><label><%=fInfo.getTotalCost()%></label></td>
												<td><label><%=fInfo.getCost()%></label>
											</tr>
											<%
											}
											}
											else{ %>
												<H3>The shopping cart is EMPTY</H3>
							 				<% }
											%>
										
									</table>
								</div>
								<input class="ClickButton" type="submit" value="Book">
							</form>

							<br>
							<form action="./FlightSearch.jsp">
								<input class="ClickButton" type="submit" value="Search a new flight">
							</form>

						
						
						
					</div>

				</div>
			</div>
		</div>
	</div>


	
	<jsp:include page="ExternalLibraryScript.jsp"></jsp:include>

</body>
</html>