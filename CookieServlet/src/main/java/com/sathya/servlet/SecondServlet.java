package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qualification=request.getParameter("qualification");
		String designation=request.getParameter("designation");
		
		Cookie cookie3=new Cookie("qualification",qualification);
		Cookie cookie4=new Cookie("designation",designation);
		
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("form23.html");
		dispatcher.forward(request, response);
	}

}
