<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<div class="section group">

	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_2_of_3">
		
		<c:choose>
			<c:when test="${empty sessionScope.clientBean }">
				<script> alert("You must be logged in to access this page.");</script>
				<jsp:forward page="./Login.jsp"></jsp:forward>
			</c:when>
			<c:otherwise>
				 
				<c:out value="${clientBean.user.fullName}" />
				<c:out value="${clientBean.organization.name}" />
					
				<a href="<c:url value='BookingHistory' />">Booking History</a>
				<a href="<c:url value='Logout' />">Logout</a>
				<a href="<c:url value='ShoppingCart.jsp' />">Shopping Cart</a>			
			</c:otherwise>	
		</c:choose>		
	</div>

</div>
