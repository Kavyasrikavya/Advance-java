package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read data from the form
        String proId = request.getParameter("proId");
        String proName = request.getParameter("proName");
        double proPrice = Double.parseDouble(request.getParameter("proPrice"));
        String proBrand = request.getParameter("proBrand");
        String proMadein = request.getParameter("proMadein");
        Date proMfgDt = Date.valueOf(request.getParameter("proMfgDt"));
        Date proExpDt = Date.valueOf(request.getParameter("proExpDt"));

        // Handle file uploads
        Part imagePart = request.getPart("proImage");
        InputStream imageInputStream = imagePart.getInputStream();
        byte[] proImage = IOUtils.toByteArray(imageInputStream);

        Part audioPart = request.getPart("proAudio");
        InputStream audioInputStream = audioPart.getInputStream();
        byte[] proAudio = IOUtils.toByteArray(audioInputStream);

        Part videoPart = request.getPart("proVideo");
        InputStream videoInputStream = videoPart.getInputStream();
        byte[] proVideo = IOUtils.toByteArray(videoInputStream);

        // Create a product object with the received data
        Product product = new Product();
        product.setProId(proId);
        product.setProName(proName);
        product.setProPrice(proPrice);
        product.setProBrand(proBrand);
        product.setProMadein(proMadein);
        product.setProMfgDt(proMfgDt);
        product.setProExpDt(proExpDt);
        product.setProImage(proImage);
        product.setProAudio(proAudio);
        product.setProVideo(proVideo);

        // Save the product using the DAO
        ProductDao productDao = new ProductDao();
        int result = productDao.save(product);

        if (result == 1) {
            // If insertion was successful, redirect to product list page
            response.sendRedirect("productList.jsp");
        } else {
            // If insertion failed, provide an error message
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("Failed to insert product data...");
            writer.close();
        }
    }
}
	
	
	
