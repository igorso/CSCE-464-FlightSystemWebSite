package ass1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

/**
 * Servlet implementation class UpdateShoppingCart.
 * This class addds a flight in the shopping cart.
 */
public class UpdateShoppingCart extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new update shopping cart.
     *
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 * After checking if the shopping cart is not empty, it updates the bean (with the total cost) and adds it in the shopping cart.
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Updating Shopping Cart");
		//Get the data:
		DetailedFlightBean toAdd= null;
		ArrayList<DetailedFlightBean> shoppingCart =  null;
		String numberSeats = Filter.cleanParameter(request.getParameter("numberSeats"));
		HttpSession session = request.getSession();
		if(session.getAttribute("shoppingCart") == null) {
			shoppingCart =  new ArrayList<DetailedFlightBean>();
			System.out.println("Shopping Cart Empty");
		}
		else {
			shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
			System.out.println("The shopping cart was not empty already "+shoppingCart.size());
		}
		
		
		
		//Update the bean:
		System.out.println("update the bean 'selectedFlight' wich is a DetailedFilghtBean");
		toAdd = (DetailedFlightBean) session.getAttribute("selectedFlight");
		toAdd.setTotalCost(toAdd.getCost()*Integer.parseInt(numberSeats));
		toAdd.setNumberOfSeat(Integer.parseInt(numberSeats));
		session.setAttribute("selectedFlight",toAdd);
		
		//Add the bean to the shopping cart:
		System.out.println("add it to the shopping cart 'shoppingCart'");
		shoppingCart.add(toAdd);
		session.setAttribute("shoppingCart", shoppingCart);
		
		//add the total cost to the session:
		int totalSCcost=0;
		//To do verify NULL!
		for (DetailedFlightBean flight : shoppingCart) {	
			totalSCcost+=flight.getTotalCost();
		}
		String StotalSCcost=String.valueOf( totalSCcost );
		System.out.println(StotalSCcost);
		session.setAttribute("totalCost", StotalSCcost);
		
		//Print the results:
		System.out.println("NumberOfSeats= "+ numberSeats);
		PrintWriter out = response.getWriter(); 
		out.println( "Your flight has been added to the shopping cart with " + numberSeats + " seats fd" );

	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post Servlet");
	}

}
