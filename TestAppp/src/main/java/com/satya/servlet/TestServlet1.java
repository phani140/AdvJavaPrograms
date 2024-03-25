package com.satya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet1")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter writer=response.getWriter();
		writer.println("testservlet executed");
	}

}
