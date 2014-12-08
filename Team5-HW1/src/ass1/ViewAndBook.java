package ass1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DetailedFlightBean;
import beans.FlightSearchBean;

/**
 * The Class ViewAndBook.
 */
public class ViewAndBook extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor.
     *
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Nothing is done here.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * For each flight in the shopping cart:
		 * 1) Use the given numberOfSeats (@ request) to query the database for available seats
		 * 2) Must also consider which class the client wants. *Use the DetailedFlightBean
		 * 3) Calculate the cost of the flight
		 * 4) Forward request to the Transaction.jsp page with the flight details, number of seats
		 *    and total cost
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//We are going to verify for all the flights in the shopping cart that there is still seats available
		boolean thereIsEnoughSeat=true;
		boolean noSeatPb=true;
		HttpSession session =request.getSession();
		ArrayList<DetailedFlightBean> shoppingCart =  null;
		if(session.getAttribute("shoppingCart") == null) {
			shoppingCart =  new ArrayList<DetailedFlightBean>();
			System.out.println("Shopping Cart Empty");
		}
		else {
			shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
			System.out.println("The shopping cart was not empty already "+shoppingCart.size());
		}

		for (DetailedFlightBean parameters : shoppingCart) {					
			//Look in the database to know if there is seats available:
			try {
				thereIsEnoughSeat = FlightsBookSQL.SeatsAvailable(parameters);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			if(thereIsEnoughSeat) {
				System.out.println("You are lucky, there is still enough seats available");
			}
			else {
				System.out.println("Sorry, we do not have enough available for this flight");
			}
			noSeatPb=noSeatPb&&thereIsEnoughSeat;
		}
		if (noSeatPb)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("ConfirmBooking.jsp"));
			dispatcher.forward(request, response);
		}else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("ClearShoppingCart"));
			System.out.println("Sorry, we do not have enough available! The shopping cart has been discarded");
			dispatcher.forward(request, response);
		}
			
	}

}