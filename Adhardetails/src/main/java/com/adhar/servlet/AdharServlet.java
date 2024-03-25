package com.adhar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdharServlet")
public class AdharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public AdharServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adharno=request.getParameter("adharno");
		String status;
		if(adharno.equals("508943451390")){
			status="same adharno matched";
		}
		else {
			status="not matched adharno";
		}
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<h1>matched adhar</h1>"+status);
		writer.println("</html>");
	}

	}
