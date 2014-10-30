package ass1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAndBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Nothing is done here
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 1) Use the given numberOfSeats (@ request) to query the database for available seats
	 * 2) Must also consider which class the client wants. *Use the DetailedFlightBean
	 * 3) Calculate the cost of the flight
	 * 4) Forward request to the Transaction.jsp page with the flight details, number of seats
	 *    and total cost
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nChosenSeats = 0;
		String snChosenSeats = request.getParameter("numberOfSeats");
		if((snChosenSeats != null) && (snChosenSeats.trim().equals("")))
			nChosenSeats = Integer.parseInt(snChosenSeats);
		
		// Query the database to see if there are nChosenSeats available at the desired flight class
		// Remember there is a DetailedFlightBean set up as a session attribute under key "selectedFlight"
		if(/*!thereIsEnoughSeats()*/false) {
			
		}
		else {
		}
		
		// Needs to calculate the cost of this flight
		float cost = 0f;
		
		// Redirects to the transaction page. Put nChosenSeats and cost at the request before forwarding
		request.setAttribute("seats", nChosenSeats);
		request.setAttribute("cost", cost);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Transaction.jsp");
		dispatcher.forward(request, response);
	}

}