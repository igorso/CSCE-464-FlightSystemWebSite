<%@page import="beans.ClientBean"%>
<div class="section group">

	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_2_of_3">
		<%
		if(request.getSession(false).getAttribute("clientBean") != null) {
		%>
			<%= 
			((ClientBean) request.getSession().getAttribute("clientBean")).getUser().getFullName()
			%>
			
			<%= 
			((ClientBean) request.getSession().getAttribute("clientBean")).getOrganization().getName()
			%>
			<a href="BookingHistory">Booking History</a>
			<a href="Logout">Logout</a>
			<a href="ShoppingCart.jsp">Shopping Cart</a>
		<%
		}
		else {
			
			response.sendRedirect("Login.jsp");
		}
		%>
	</div>

</div>