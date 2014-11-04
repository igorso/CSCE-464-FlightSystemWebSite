package ass1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import com.itextpdf.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

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
		int error=0;
		int account_id=Integer.parseInt((String) request.getParameter("accountId"));
		int holder_id=Integer.parseInt((String) request.getParameter("holderId"));
		int routing_number=Integer.parseInt((String) request.getParameter("routing"));
		DetailedFlightBean parameters= null;
		HttpSession session = request.getSession();
		parameters = (DetailedFlightBean) session.getAttribute("selectedFlight");
		
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		int user_id=userBean.getId();
		System.out.println("The user id is:"+ user_id);
		//Have to get all the parameters:
		try {
			error=AccountSQL.transaction_successfull(parameters, account_id, holder_id, routing_number, user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The error returned by the booking is "+ error);
		//0 if everything was OK
		//1 if the account was not found
		//2 if there is not enough money
		//3 if there is a database problem		
		request.setAttribute("transaction", new Boolean(true));
		
		//Dispatch results to view JSP
		//RequestDispatcher dispatcher = request.getRequestDispatcher("TransactionConfirmation.jsp");
		//dispatcher.forward(request, response);
		
	}
	
	public void PDF (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		//Get the data from the session:
		
		//HttpSession session = request.getSession();
		DetailedFlightBean flightDetail = new DetailedFlightBean();//(DetailedFlightBean) session.getAttribute("selectedFlight");		
		UserBean userBean = new UserBean();//(UserBean) session.getAttribute("userBean");
		//ManagementPDF.printPDF(flightDetail, userBean);
		
		
		String pdfFileName = "FirstPDF.pdf";
		String contextPath = getServletContext().getRealPath(File.separator);
		File pdfFile = new File(contextPath + pdfFileName);
		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + pdfFileName);
		response.setContentLength((int) pdfFile.length());
		
		FileInputStream fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}


	}
}
