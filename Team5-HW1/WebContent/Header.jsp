<div class="section group">

	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_1_of_3">
		<%
		if(request.getSession(false).getAttribute("session_username") != null) {
		%>
		<button onclick=">Logout</button>
		<%
		}
		%>
	</div>

</div>