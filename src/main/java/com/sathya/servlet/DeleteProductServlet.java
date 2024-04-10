package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String proId=request.getParameter("proId");
		
		ProductDao productDao=new ProductDao();
		
		int result = productDao.deleteById(proId);
	      if(result==1)
	      {
	    	  //to send the data to jsp to add the data to request
	    	  request.setAttribute("deleteResult",result);
	    	  RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp" );
	    	  dispatcher.forward(request, response);
	    	  
	      }
	      else
	      {
	    	 
	     
		response.setContentType("text/html");
			
		PrintWriter Writer=response.getWriter();
		
		Writer.println("data delete fail..."+result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
		dispatcher.include(request, response);
		}

	}

}
