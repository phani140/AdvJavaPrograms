package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public HelloWorldServlet() {
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        PrintWriter writer=response.getWriter();
		        //response.setContentType("");
		        writer.println("<html>");
		        writer.println("<h1>this is web app first servelt app</h1>");
		        writer.println("<h2>this is ratan sir class</h2>");
		        writer.println("<html>");
	}

		

}
