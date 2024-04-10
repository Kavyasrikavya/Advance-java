<%@page import="com.sathya.servlet.ProductDao"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>ProductList</title>
    <!-- Bootstrap CDN link to get the support of Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <h1 class="text-center font-italic mb-1 text-success">List of Available Product....</h1>

    <div>
        <a href="productList.jsp" class="btn btn-success">Save Product</a>
    </div>

    <div>
        <input type="text" placeholder="search">
    </div>

    <div>
        <c:if test="${saveResult==1}">
            <h2 class="text-success text-center">Data inserted successfully......</h2>
        </c:if>
    </div>

    <div>
        <c:if test="${deleteResult==1}">
            <h2 class="text-success text-center">Data delete successfully......</h2>
        </c:if>
    </div>

    <div>
        <c:if test="${deleteResult==0}">
            <h2 class="text-success text-center">Data delete fail......</h2>
        </c:if>
    </div>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Cost</th>
                <th>Brand</th>
                <th>MadeIn</th>
                <th>Manufacture Date</th>
                <th>EXP Date</th>
                <th>Image</th>
                <th>Audio</th>
                <th>Video</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.proId}</td>
                    <td>${product.proName}</td>
                    <td>${product.proPrice}</td>
                    <td>${product.proBrand}</td>
                    <td>${product.proMadein }</td>
                    <td>${product.proMfgDt}</td>
                    <td>${product.proExpDt}</td>
                    <!-- Display image using img tag -->
                    <td>
                        <img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}"
                            alt="ProductImage" style="max-width:100px; max-height:100px;">
                    </td>

                    <!-- Display audio using audio tag -->
                    <td>
                        <audio controls>
                            <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"
                                type="audio/mpeg">
                        </audio>
                    </td>

                    <!-- Display video using video tag -->
                    <td>
                        <video controls width="320" height="240">
                            <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}"
                                type="video/mp4">
                        </video>
                    </td>

                    <td>
                        <a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete</a>
                        <a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>