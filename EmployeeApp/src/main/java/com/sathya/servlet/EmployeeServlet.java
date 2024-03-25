package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
			//step1: read the data
			int empId=Integer.parseInt(request.getParameter("empId"));
			String empName=request.getParameter("empName");
			double empBasicSalary=Double.parseDouble(request.getParameter("empBasicSalary"));
			
			//step2:process the data
			double HRA,DA,PF,grossSalary;
			if(empBasicSalary>=50000) {
				HRA=0.3*empBasicSalary;
				DA=0.1*empBasicSalary;
				PF=0.06*empBasicSalary;
			}
			else if(empBasicSalary>25000&&empBasicSalary<50000) {
				HRA=0.2*empBasicSalary;
				DA=0.05*empBasicSalary;
				PF=0.03*empBasicSalary;
			}
			else{
				HRA=0.1*empBasicSalary;
				DA=0.03*empBasicSalary;
				PF=0.02*empBasicSalary;
			}
			grossSalary=empBasicSalary+HRA+DA+PF;
			
			//step3 render the response
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("Employee Id:"+empId);
			writer.println("<br><br>");
			writer.println("Employee Name: "+empName);
			writer.println("<br><br>");
			writer.println("Employee BasicSalary: "+empBasicSalary);
			writer.println("<br><br>");
			writer.println("HRA Amount: "+HRA);
			writer.println("<br><br>");
			writer.println("DA Amount: "+DA);
			writer.println("<br><br>");
			writer.println("PF Amount: "+PF);
			writer.println("<br><br>");
			writer.println("Gross Salary: "+grossSalary);
			writer.println("</html>");			
		
	}

	
}
