package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		PrintWriter Writer=response.getWriter();
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<body style='color:purple'>");
		Writer.println("<h1>REGISTRATION STATUS...</h1>");
		Writer.println("<pre>");
		Writer.println("username...."+session.getAttribute("username"));
		Writer.println("<br><br>");
		Writer.println("age...."+session.getAttribute("age"));
		Writer.println("<br><br>");
		Writer.println("qualification...."+session.getAttribute("qualification"));
		Writer.println("<br><br>");
		Writer.println("designation...."+session.getAttribute("designation"));
		Writer.println("<br><br>");
		Writer.println("email...."+request.getParameter("email"));
		Writer.println("<br><br>");
	    Writer.println("mobile..."+request.getParameter("mobile"));
	    Writer.println("<br><br>");
		Writer.println("</pre>");
		Writer.println("</body>");
		Writer.println("</html>");
	}
}


