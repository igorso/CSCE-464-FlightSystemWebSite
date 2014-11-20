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
import beans.UserBean;

/**
 * Servlet implementation class UpdateBooking
 */
public class UpdateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the parameters:
		String account_idS = request.getParameter("account_id");//TO DO PASS IT IN THE REQUEST ZND VERIFY NULL
		int account_id=5; //TO DO parseint();
		ArrayList<DetailedFlightBean> shoppingCart =  null;
		HttpSession session = request.getSession();
		if(session.getAttribute("shoppingCart") == null) {
			shoppingCart =  new ArrayList<DetailedFlightBean>();
			System.out.println("Shopping Cart Empty");
		}
		else {
			shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
		}
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		int user_id=userBean.getId();
		System.out.println("The user id is:"+ user_id);
		
		//update the database:
		int error=0;
		try {
			error=AccountSQL.updateDB(shoppingCart, account_id,  user_id);
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
		
		if(error == 0)
			request.setAttribute("transaction", new Boolean(true));
		else {
			request.setAttribute("transaction", new Boolean(false));
			request.setAttribute("errorMessage", errorMessage);
		}
		//Dispatch results to view JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionConfirmation.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
