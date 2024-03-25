package com.sathya.product;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       public AddProductServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the data
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		float proPrice=Float.parseFloat(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		
		//conversion of InputStream to byteArray
		byte[] proImage=IOUtils.toByteArray(inputStream);
		
		Part Audio=request.getPart("proAudio");
		InputStream inputStreamAudio=Audio.getInputStream();
		
		//conversion of InputStream to byteArray
		byte[] proAudio=IOUtils.toByteArray(inputStreamAudio);
		
		Part Video=request.getPart("proVideo");
		InputStream inputStreamVideo=Video.getInputStream();
		
		//conversion of InputStream to byteArray
		byte[] proVideo=IOUtils.toByteArray(inputStreamVideo);
		
		//Using above details create the product Object
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
		
		//Giving the product Object to DAO layer
		ProductDao productDao=new ProductDao();
		int result=productDao.save(product);
		
		if(result==1) {
			request.setAttribute("saveResult", result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else {
		PrintWriter writer =response.getWriter();
		writer.println("Data Insertion fail...."+result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
		dispatcher.include(request, response);
		
		}
	}
		

}
