package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OneMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       public OneMoreServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		writer.println("the adv java classes ");
		writer.println("the java");
		}

}
