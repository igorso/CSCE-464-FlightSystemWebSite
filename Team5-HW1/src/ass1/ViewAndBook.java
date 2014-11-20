package ass1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DetailedFlightBean;
import beans.FlightSearchBean;

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

		
			nChosenSeats = Integer.parseInt(snChosenSeats);
			System.out.println("You want "+nChosenSeats+" seats");
		boolean thereIsEnoughSeat=false;
		
		HttpSession session =request.getSession();
		DetailedFlightBean parameters= (DetailedFlightBean) session.getAttribute("selectedFlight");
		// Query the database to search for the selected flight
		
		//Look in the database if there is still enough seats available:
		DetailedFlightBean flight = null;
		try {
			thereIsEnoughSeat = FlightsBookSQL.SeatsAvailable(parameters, nChosenSeats);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(thereIsEnoughSeat) {
			System.out.println("You are lucky, there is still "+nChosenSeats +" available");
		}
		else {
			System.out.println("Sorry, we do not have "+nChosenSeats +" available");
		}
		
		// Needs to calculate the cost of this flight
		float cost = parameters.getCost()*nChosenSeats;
		parameters.setNumberOfSeat(nChosenSeats);
		// Redirects to the transaction page. Put nChosenSeats and cost at the request before forwarding
		request.setAttribute("seats", nChosenSeats);
		
		request.setAttribute("cost", cost);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Transaction.jsp");
		dispatcher.forward(request, response);
	}

}