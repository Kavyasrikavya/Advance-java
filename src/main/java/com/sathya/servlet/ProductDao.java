package com.sathya.servlet;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;







public class ProductDao {
	 public int save(Product product) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        int count = 0;
	        
	        try {
	            // Establish database connection
	            connection = DBConnection.createConnection();
	            // Create SQL statement for insertion
	            preparedStatement = connection.prepareStatement("INSERT INTO Product_data VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	            // Set parameters for the statement
	            preparedStatement.setString(1, product.getProId());
	            preparedStatement.setString(2, product.getProName());
	            preparedStatement.setDouble(3, product.getProPrice());
	            preparedStatement.setString(4, product.getProBrand());
	            preparedStatement.setString(5, product.getProMadein());
	            preparedStatement.setDate(6, product.getProMfgDt());
	            preparedStatement.setDate(7, product.getProExpDt());
	            preparedStatement.setBytes(8, product.getProImage());
	            preparedStatement.setBytes(9, product.getProAudio());
	            preparedStatement.setBytes(10, product.getProVideo());
	            // Execute the statement
	            count = preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return count;
	    }
		public List<Product> findAll() 
	{
		List<Product> pr=new ArrayList<Product>();
		try(Connection connection=DBConnection.createConnection();
	        PreparedStatement preparedStatement=connection.prepareStatement("select * from  Product_data"))
				{
			    
			    ResultSet resultSet=preparedStatement.executeQuery();
			   while(resultSet.next())
			    {
			    	Product product =new Product();
			    	
			    	
			    	product.setProId(resultSet.getString("proId"));
			    	product.setProName(resultSet.getString("proName"));
			    	product.setProPrice(resultSet.getDouble("proPrice"));
			    	product.setProBrand(resultSet.getString("proBrand"));
			    	product.setProMadein(resultSet.getString("proMadein"));
			    	product.setProMfgDt(resultSet.getDate("proMfgDt"));
			    	product.setProExpDt(resultSet.getDate("proExpDt"));
			        product.setProImage(resultSet.getBytes("proImage"));
			        product.setProAudio(resultSet.getBytes("proAudio"));
			        product.setProVideo(resultSet.getBytes("proVideo"));
			        
			    	pr.add(product);
			    	
				  }
	    
				 }
	                 catch(SQLException e)
	                  {
	                     e.printStackTrace();	
	                   }
	         return pr; 
	} 
	public int deleteById(String proId) 
	 {
		
		 int count=0;
		 try(Connection connection=DBConnection.createConnection();
		   PreparedStatement preparedStatement=connection.prepareStatement("delete from Product_data where proId=?"))
		 {
		 preparedStatement.setString(1,proId);
		 count=preparedStatement.executeUpdate();
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		return count;
	}
	
	
	public Product findById(String proId) 
	{
		Product product=null;
		try(Connection connection=DBConnection.createConnection();
	        PreparedStatement preparedStatement=connection.prepareStatement("select * from Product_data  where proId=?"))
				{
			    preparedStatement.setString(1,proId );
			    ResultSet resultSet=preparedStatement.executeQuery();
			    if(resultSet.next())
			    {
			    product=new Product();
			    product.setProId(resultSet.getString("proId"));
		    	product.setProName(resultSet.getString("proName"));
		    	product.setProPrice(resultSet.getDouble("proPrice"));
		    	product.setProBrand(resultSet.getString("proBrand"));
		    	product.setProMadein(resultSet.getString("proMadein"));
		    	product.setProMfgDt(resultSet.getDate("proMfgDt"));
		    	product.setProExpDt(resultSet.getDate("proExpDt"));
		        product.setProImage(resultSet.getBytes("proImage"));
		        product.setProAudio(resultSet.getBytes("proAudio"));
		        product.setProVideo(resultSet.getBytes("proVideo"));
				}
	    
				}
	       catch(SQLException e)
	        {
	            e.printStackTrace();	
	        }
	         return product; 
	}  
	public int UpdateById(Product product)
	{
		String sql="UPDATE Product_data SET proName=?,proPrice=?,proBrand=?,proMadein=?,proMfgDt=?,proExpDt=?,proAudio=?,proVideo=? WHERE proId=?";
		int updateResult=0;
		try(Connection connection=DBConnection.createConnection();
				   PreparedStatement preparedStatement=connection.prepareStatement(sql))
				{
		
		   	     preparedStatement.setString(1, product.getProName());
		   	     preparedStatement.setDouble(2, product.getProPrice());
		   		 preparedStatement.setString(3, product.getProBrand());
		   		 preparedStatement.setString(4, product.getProMadein());
		   		 preparedStatement.setDate(5, product.getProMfgDt());
		   		 preparedStatement.setDate(6, product.getProExpDt());
		   		 preparedStatement.setBytes(7, product.getProImage());
		   		 preparedStatement.setBytes(8, product.getProAudio());
		   		 preparedStatement.setBytes(9, product.getProVideo());
		   		 preparedStatement.setString(10, product.getProId());

		   		 updateResult=preparedStatement.executeUpdate();
		   	 	}
		 
		   	 catch(ClassCastException |SQLException e)
		   	 {
		   		 e.printStackTrace();
		   	 }
		return updateResult;
	}
}
