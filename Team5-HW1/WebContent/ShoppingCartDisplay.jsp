<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import=" java.util.ArrayList, beans.DetailedFlightBean"%>

<%
if(request.getSession(false).getAttribute("shoppingCart") != null) {
	ArrayList<DetailedFlightBean> shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
%>

<div class="FlightTable">
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
%>			
	</table>
</div>
<%
}
else {
%>
<h3>The shopping cart is empty</h3>
<%
							}
							%>