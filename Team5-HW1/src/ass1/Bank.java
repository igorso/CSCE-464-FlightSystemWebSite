package ass1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
/**
 * Servlet implementation class UpdateShoppingCart
 */
public class Bank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Beginning to process");
		//Get the data:
		
		// Ask the database if the client has enough balance
		// On success the booking details are added to the booking history via the booking model
		// Redirect user to the TransactionConfirmation.jsp page with flight details and 
		// transaction status (Success/Failure)
		
		//get the datas:
		int payementError=0;
		
		//To do look for null value here
		int account_id=Integer.parseInt((String) request.getParameter("accountId"));
		int holder_id=Integer.parseInt((String) request.getParameter("holderId"));
		int routing_number=Integer.parseInt((String) request.getParameter("routing"));

		HttpSession session = request.getSession();
		int totalSCcost=0;
		ArrayList<DetailedFlightBean> shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
		//To do verify NULL!
		for (DetailedFlightBean flight : shoppingCart) {	
			totalSCcost+=flight.getTotalCost();
		}
		

		//Query the database to make the payment:
		try {
			payementError=AccountSQL.Payement(account_id,holder_id, routing_number,totalSCcost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The error returned by the payement is"+ payementError);
		
		String errorMessage = "";
		switch(payementError) {
		//0 if everything was OK
		//1 if the account was not found
		//2 if there is not enough money
		//3 if there is a database problem
		//case 0: message = "The transaction was a success!"; break;
		case 1: errorMessage = "Sorry, the desidered account was not found."; break;
		case 2: errorMessage = "The account's balance was not enough to complete the transaction."; break;
		case 3: errorMessage = "There was a problem with your Bank DataBase. Your transaction failed."; break;
		}
		PrintWriter out = response.getWriter(); 
		if(payementError == 0)
		{
			request.setAttribute("transaction", new Boolean(true));
			out.println( "Work#The bank accepted the payment" );
		}
		else {
			out.println( "NotWork#"+  errorMessage);
			request.setAttribute("transaction", new Boolean(false));
			request.setAttribute("errorMessage", errorMessage);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post Servlet");
	}

}
