package ass1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;


import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;


/*
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
*/
import beans.DetailedFlightBean;
import beans.UserBean;

/**
 * Servlet implementation class PrinterPDF
 */
public class PrinterPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrinterPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		System.out.println("Do post of printer");
		//Get the data from the session:
		//HttpSession session = request.getSession();
		DetailedFlightBean flightDetail = new DetailedFlightBean();//(DetailedFlightBean) session.getAttribute("selectedFlight");		
		UserBean userBean = new UserBean();//(UserBean) session.getAttribute("userBean");
		
		//Create the PDF with the beans:
		String pdfFileName = "FirstPdf.pdf";
		String contextPath = getServletContext().getRealPath(File.separator);
		createPDF(flightDetail, userBean,contextPath + pdfFileName);
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

	}
	
	/**
	 * Creates the pdf (by calling ManagementPDF).
	 *
	 * @param details the details
	 * @param user the user
	 * @param path the path
	 */
	void createPDF(DetailedFlightBean details,UserBean user,String path)
	  {
		System.out.println("We will create the pdf file with the bookinge We are in the servlet"+path);
		ManagementPDF.createPDF(details, user,path); //This is where it does not work! Error 500
	  }
}
