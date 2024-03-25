package com.sathya.product;

import java.io.IOException;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;
 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		String UpdateProductName=request.getParameter("proName");
		float UpdateProductPrice=Float.parseFloat(request.getParameter("proPrice"));
		String UpdateProductBrand=request.getParameter("proBrand");
		String UpdateProductMadeIn=request.getParameter("proMadeIn");
		Date UpdateProductMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date UpdateProductExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(UpdateProductName);
		product.setProPrice(UpdateProductPrice);
		product.setProBrand(UpdateProductBrand);
		product.setProMadeIn(UpdateProductMadeIn);
		product.setProMfgDate(UpdateProductMfgDate);
		product.setProExpDate(UpdateProductExpDate);
		
		
		Part filePart=request.getPart("newProImage");
		if(filePart!=null &&filePart.getSize()>0) {
			InputStream inputStream=filePart.getInputStream();
			byte[] newImageData=IOUtils.toByteArray(inputStream);
			product.setProImage(newImageData);
			
		}
		else {
			String s=request.getParameter("existingImage");
			byte[] existingImage=Base64.getDecoder().decode(s);
			product.setProImage(existingImage);
		}
		
		
		ProductDao dao=new ProductDao();
		int result=dao.UpdateById(product);
		
		if(result==1) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter writer =response.getWriter();
			writer.println("Data Insertion fail...."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
	}
	}

}
