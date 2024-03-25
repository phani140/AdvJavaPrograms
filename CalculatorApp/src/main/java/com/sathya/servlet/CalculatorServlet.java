package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public CalculatorServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step1: get the data
		int first=Integer.parseInt(request.getParameter("first"));
		int second=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		//step2:process the data
		int result=0;
		switch(operation) {
		   case "+":result=first+second;
		   break;
		   case "-":result=first-second;
           break;
		   case "*":result=first*second;
           break;
		   case "/":result=first/second;
           break;
		   case "%":result=first%second;
           break;

        }
		
		//step3: render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<p>First number:"+first+"</p>");
		writer.println("<p>Second number:"+second+"</p>");
		writer.println("<p>operator :"+operation+"</p>");
		writer.println("<p>Result :"+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

	

}
