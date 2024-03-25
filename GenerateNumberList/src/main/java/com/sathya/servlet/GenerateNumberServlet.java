package com.sathya.servlet;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GenerateNumberServlet")
public class GenerateNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

        public GenerateNumberServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> al=new ArrayList<Integer>();

		//step1:get the data
		int start=Integer.parseInt(request.getParameter("start"));
		int end=Integer.parseInt(request.getParameter("end"));
		String operation=request.getParameter("operation");
		
		//step2 process the data
		switch(operation) 
		{
		
		case "even":
		for(int i=start;i<=end;i++) {
			if(i%2==0) {
			  	al.add(i);
			}
		}
		   break;
		 case "odd":
       	  for(int i=start;i<=end;i++)
       	  {
       		  if(i%2!=0)
       			  al.add(i);
       	  }
        case "prime":
       	   int count=0;
       	  for(int i=start;i<=end;i++)
       	  {
       		  count=0;
       		  for(int j=1;j<=i;j++)
       		  {
       			  if(i%j==0)
       				  count++;
       		  }
       		  if(count==2)
       			  al.add(i);
       	  }
       	  break;
        case "perfect":
       	  int sum=0;
       	  for(int i=start;i<=end;i++)
       	  { 
       		  sum=0;
       		  for(int j=1;j<i;j++)
       		  {
       				if(i%j==0)
       					sum=sum+j;
       				   }
       		   if(sum==i)
       			   al.add(i);
       		   }
       	  break;
         case "strong":
       	  int fact=1,sum1=0,temp1,rem;
       	  for(int i=start;i<=end;i++)
       	  {
       		  temp1=i;
       		  sum=0;
       		   while(temp1>0)
       		   {
       			   rem=temp1%10;
       		  
       		     if(rem==0)
       		    	 fact=1;
       		     else
       			    {
       		    	   fact=1;
       			    	for(int j=rem;j>=1;j--)
       			    		fact=fact*j;
       			    }
       			    sum=sum+fact;
       			    temp1=temp1/10;
       		  }
       		  if(sum==i)
       			  al.add(i);
       	  }
       	  break;
        case "armstrong":
       	  int temp,temp2,rem1,sum2=0,count1=0,x,y;
       	  for(int i=start;i<=end;i++)
       	  {
       		  temp=i;
       		  sum2=0;
       		  count1=0;
       		  while(temp>0)
       		  {
       			  temp=temp/10;
       			  count1++;
       		  }
       		  temp2=i;
       		  
       		  while(temp2>0)
       		  {
       			  rem=temp2%10;
       			  y=count1;
       		     x=1;
       			  while(y>0)
       			  {
       				  x=x*rem;
       			    y--;
       		  }
       	  sum2=sum2+x;
       	  temp2=temp2/10;
       	  }
           if(sum2==i)
           	al.add(i);
         }
       	  break;
		}
		
		//step3:render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<p>Start number:"+start+"</p>");
		writer.println("<p>End number:"+end+"</p>");
		writer.println("<p>operator :"+operation+"</p>");
		writer.println(al+"<br>");
		writer.println("</body>");
		writer.println("</html>");
		
	}	
		
}
