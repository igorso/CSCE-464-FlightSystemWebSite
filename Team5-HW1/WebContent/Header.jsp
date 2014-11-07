<%@page import="beans.UserBean"%>
<div class="section group">

	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_2_of_3">
		<%
		if(request.getSession(false).getAttribute("userBean") != null) {
		%>
			<%= 
			((UserBean) request.getSession().getAttribute("userBean")).getEmail()
			%>
			<a href="BookingHistory">Booking History</a>
			<a href="Logout">Logout</a>
		<%
		}
		%>
	</div>

</div>