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

import beans.ClientBean;
import beans.DetailedFlightBean;
import beans.UserBean;

/**
 * Servlet implementation class UpdateBooking.
 */
public class UpdateBooking extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new update booking.
     *
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 * This is a separate servlet called only by AJAX.
	 * This servlet update the database and return a string in the request:
	 * 		Work#Your tickets have been registered in our database
	 *	 	NotWork#"error"
	 * The results will be parsed after by the ConfirmBooking.jsp
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the parameters:
		String account_idS = Filter.cleanParameter(request.getParameter("accountId"));
		
		int account_id=Integer.parseInt(account_idS); 
		System.out.println("Account Id"+ account_id);
		ArrayList<DetailedFlightBean> shoppingCart =  null;
		HttpSession session = request.getSession();
		if(session.getAttribute("shoppingCart") == null) {
			shoppingCart =  new ArrayList<DetailedFlightBean>();
			System.out.println("Shopping Cart Empty");
		}
		else {
			shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
		}
		ClientBean client= (ClientBean) session.getAttribute("clientBean");
		if (client==null)
		{
			response.sendRedirect(response.encodeRedirectURL("Logout.java"));
		}
		UserBean userBean=client.getUser();
				
		int user_id=userBean.getId();
		System.out.println("The user id is:"+ user_id);
		
		//update the database:
		int error=0;
		try {

			error=AccountSQL.updateDB(shoppingCart,   user_id,account_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String errorMessage = "";
		switch(error) {
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
		if(error == 0)
		{
			out.println( "Work#Your tickets have been registered in our database" );
		}
		else {
			out.println( "NotWork#"+  errorMessage);
		}
		
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
		// TODO Auto-generated method stub
	}

}
