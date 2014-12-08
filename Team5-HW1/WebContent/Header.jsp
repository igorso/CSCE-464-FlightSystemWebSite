<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<div class="section group">

	<div class="col span_1_of_3">
	</div>
	
	<div class="col span_2_of_3">
		
		<c:choose>
			<c:when test="${empty sessionScope.clientBean }">
				<p>entro</p>
				<c:redirect url="/Team5-HW3-AirlineReservation/Registration.jsp" />
				<script type="text/javascript"> alert("hehe");</script> 
			</c:when>
			<c:otherwise>
				${clientBean.user.fullName} 
					
				${clientBean.organization.name}
					
				<a href="<c:url value='BookingHistory' />">Booking History</a>
				<a href="<c:url value='Logout' />">Logout</a>
				<a href="<c:url value='ShoppingCart.jsp' />">Shopping Cart</a>			
			</c:otherwise>	
		</c:choose>		
	</div>

</div>