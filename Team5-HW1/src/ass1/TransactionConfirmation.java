package ass1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.FlightResultBean;
import beans.FlightSearchBean;

public class TransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * We do not use the constructor
     * @see HttpServlet#HttpServlet()
     */
    public TransactionConfirmation() {
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
	 * 1) Use the bank details from Transaction.jsp to verify the balance at transaction model at the database
	 * @see 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ask the database if the client has enough balance
		// On success the booking details are added to the booking history via the booking model
		// Redirect user to the TransactionConfirmation.jsp page with flight details and 
		// transaction status (Success/Failure)

		request.setAttribute("transaction", new Boolean(true));
		
		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionConfirmation.jsp");
		dispatcher.forward(request, response);
	}
}
