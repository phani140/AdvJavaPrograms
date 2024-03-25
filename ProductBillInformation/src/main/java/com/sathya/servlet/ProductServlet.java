package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       public ProductServlet() {
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//step1:read the data
			int productId=Integer.parseInt(request.getParameter("productId"));
			String productName=request.getParameter("productName");
			double productPrice=Double.parseDouble(request.getParameter("productPrice"));
			int productQuantity=Integer.parseInt(request.getParameter("productQuantity"));
			
			//step2:process the data
			
			double totalBill=productPrice*productQuantity;
			double discount=0;
			double netAmount=0;
			
			if(totalBill<1000) {
				
				discount=totalBill;
				netAmount=totalBill-discount;
			}
			else if(totalBill>1000&&totalBill<5000) {
				
				discount=0.05*totalBill;
				netAmount=totalBill-discount;
			}
			else if(totalBill>5000&&totalBill<10000) {
				
				discount=0.1*totalBill;
				netAmount=totalBill-discount;
			}
			else {
				
				discount=0.15*totalBill;
				netAmount=totalBill-discount;
			}
			
			
			//step render the response
			
            PrintWriter writer=response.getWriter();
            response.setContentType("text/html");
            writer.println("<html>");
            writer.println("product ID is "+productId);
            writer.println("<br><br>");
            writer.println("product Name is "+productName);
            writer.println("<br><br>");
            writer.println("product Price is "+productPrice);
            writer.println("<br><br>");
            writer.println("product Quantity are "+productQuantity);
            writer.println("<br><br>");
            writer.println("Total Bill="+totalBill);
            writer.println("<br><br>");
            writer.println("Discount="+discount);
            writer.println("<br><br>");
            writer.println("Net Amount="+netAmount);
            writer.println("</html>");
            
            
			}

	
}
