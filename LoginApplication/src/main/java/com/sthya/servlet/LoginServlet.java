package com.sthya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

      public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String username=request.getParameter("username");
		      String password= request.getParameter("password");
		      
		      String status;
		      if(username.equals("Sathya")&&password.equals("chinni@123")) 
		      {
		    	  status="Login successful";
		    	  RequestDispatcher dispatcher=request.getRequestDispatcher(status);
		    	  
		      }
		      else {
		    	  status="login fail";
		      }
		      
		      PrintWriter writer=response.getWriter();
		      writer.println("<html>");
		      writer.println("<h1>login status</h1>"+status);
		      writer.println("</html>");
		}

	}
