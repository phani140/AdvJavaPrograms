package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/thirdServlet")
public class thirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   Cookie[] cookies=request.getCookies();
    	   PrintWriter Writer=response.getWriter();
		
		response.setContentType("text/html");
		Writer.println("<html>");
		Writer.println("<body style='color:green'>");
		Writer.println("<h1>REGISTRATION STATUS...</h1>");
		Writer.println("<pre>");
		Writer.println("username...."+cookies[0].getValue());
		Writer.println("<br><br>");
		Writer.println("age...."+cookies[1].getValue());
		Writer.println("<br><br>");
		Writer.println("qualification...."+cookies[2].getValue());
		Writer.println("<br><br>");
		Writer.println("designation...."+cookies[3].getValue());
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