package ass1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DetailedFlightBean;
import beans.UserBean;


/**
 * Servlet implementation class PrinterPDF.
 */
public class PrinterPDF extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /**
     * Instantiates a new printer pdf.
     *
     * @see HttpServlet#HttpServlet()
     */
    public PrinterPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		System.out.println("Do post of printer");
		//Get the data from the session:		
		ArrayList<DetailedFlightBean> shoppingCart =  null;
		HttpSession session = request.getSession();
		if(session.getAttribute("shoppingCart") == null) {
			shoppingCart =  new ArrayList<DetailedFlightBean>();
			System.out.println("Shopping Cart Empty");
		}
		else {
			shoppingCart = (ArrayList<DetailedFlightBean>) session.getAttribute("shoppingCart");
			//System.out.println("The shopping cart was not empty already "+shoppingCart.size());
		}
		UserBean userBean = (UserBean) session.getAttribute("userBean");
		
		//Get the data from the request:
		 String name = request.getParameter("name");
	     String age = request.getParameter("age");
	     String sex = request.getParameter("sex");
	     String toWrite= name+ "\n"+ age+ "\n" +sex+"\n";
	     System.out.println(toWrite);
		//Create the PDF with the beans:
		String pdfFileName = "Tickets.pdf";
		String contextPath = getServletContext().getRealPath(File.separator);
		ManagementPDF.createPDF(shoppingCart, userBean,contextPath + pdfFileName, name,age,sex); 
		//createPDF(flightDetail, userBean,contextPath + pdfFileName);
		System.out.println("End of the PDF print");
		
		//Display it on the screen:
		//System.out.println(contextPath);
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
		fileInputStream.close();

	}
	
}
