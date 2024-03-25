package com.company.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeDetails
 */
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeDetails() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String fullname=request.getParameter("fullname");
			String Designation=request.getParameter("Designation");
			String status;
			if(fullname.equals("phani")&&Designation.equals("developer")) {
				status="details matched";
			}
			else {
				status="not matched";
			}
			
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<h1>Employeedetails</h1>"+status);
			writer.println("</html>");
	}


}
