package com.name.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public NameServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("middlename");
		String lastname=request.getParameter("lastname");
		
		String fullname;
		fullname=firstname+" "+middlename+" "+lastname;
		
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<h1>Fullname</h1>"+fullname);
		writer.println("</html");
	}

	

}
