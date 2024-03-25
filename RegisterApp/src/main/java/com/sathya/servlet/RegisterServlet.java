package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step1:read the data
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		long mobile =Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("DOB");
		String quals[]= request.getParameterValues("Qualification");
		String country=request.getParameter("Country");
		String languages[]=request.getParameterValues("languages");
		String comments=request.getParameter("Comments");
		
		//step2:process the data
		 String q=String.join(",",quals);
		 String l=String.join("-",languages);
		  
		//step 3:render the response
		  response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("username:"+username);
			writer.println("<br><br>");
			writer.println("password: "+password);
			writer.println("<br><br>");
			writer.println("mobile: "+mobile);
			writer.println("<br><br>");
			writer.println("email: "+email);
			writer.println("<br><br>");
			writer.println("gender: "+gender);
			writer.println("<br><br>");
			writer.println("dob: "+dob);
			writer.println("<br><br>");
			writer.println("qualification: "+q);
			writer.println("<br><br>");
			writer.println("country: "+country);
			writer.println("<br><br>");
			writer.println("languages: "+l);
			writer.println("<br><br>");
			writer.println("comments: "+comments);
			writer.println("</html>");			
		
		  
	}		
		
}
