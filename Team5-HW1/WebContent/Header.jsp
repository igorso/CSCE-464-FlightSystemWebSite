<div class="section group">

	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_1_of_3">
		<%
		if(request.getSession(false).getAttribute("userBean") != null) {
		%>
		<a href="Logout">Logout</a>
		<%
		}
		%>
	</div>

</div>