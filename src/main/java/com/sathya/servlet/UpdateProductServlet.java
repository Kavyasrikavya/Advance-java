package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateProductServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data from formdata
		String proId=request.getParameter("proId");
		String UpdateproName=request.getParameter("proName");
		double  UpdateproPrice=Double.parseDouble(request.getParameter("proPrice"));
		String UpdateproBrand=request.getParameter("proBrand");
		String UpdateproMadein=request.getParameter("proMadein");
		Date UpdateproMfgDt=Date.valueOf(request.getParameter("proMfgDt"));
		Date UpdateproExpDt=Date.valueOf(request.getParameter("proExpDt"));
		
		
		
		//using above details create the product object
		 //byte[]proImage=IOUtils.toByteArrays(inputStream);
		
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(UpdateproName);
		product.setProPrice(UpdateproPrice);
		product.setProBrand(UpdateproBrand);
		product.setProMadein(UpdateproMadein);
		product.setProMfgDt(UpdateproMfgDt);
		product.setProExpDt(UpdateproExpDt);
		
		
		Part filePart=request.getPart("newImage"); //newproimage is the name of your file thename of your file input field
		//your file input field
		if(filePart!=null && filePart.getSize()>0){
			InputStream inputStream=filePart.getInputStream();
			byte[] newImage=IOUtils.toByteArray(inputStream);
			product.setProImage(newImage);
		}
		else
		{
			String s=request.getParameter("existingImage");
			byte[] existingImage=Base64.getDecoder().decode(s);
			product.setProImage(existingImage);
		}	
		ProductDao productDao=new ProductDao();
		
		int result = productDao.UpdateById(product);
	      if(result==1)
	      {
	    	  
	    	  RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp" );
	    	  dispatcher.forward(request, response);
	    	  
	      }
	      else
	      {
	    	//to get the data file 
	     
		response.setContentType("text/html");
			
		PrintWriter Writer=response.getWriter();
		
		Writer.println("data inserted fail..."+result);
		RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
		dispatcher.forward(request, response);
		}
			 
		}
	}


