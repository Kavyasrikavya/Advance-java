<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" >

</head>
<body>
<div class="container mt-5 text-center">

<h2 class="text-center  font -italic  mb-2" >Save Product data....</h2>
<form method="post" action="./AddProductServlet" enctype="multipart/form-data" onsubmit="return validationForm()">

<div class="form-group">
<label class="font-italic font-weight-bold" for="proId">ProductId:</label>
<input type="text" class="form-control-sm"  id="proId"  name="proId"  value="${existingProduct.proId}" required>
</div>



<div class="form-group">
<label class="font-italic font-weight-bold" for="proName">ProductName:</label>
<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingProduct.proName}"required>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proPrice">ProductsPrice:</label>
<input type="text" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice}" required>
</div>



<div class="form-group">
<label class="font-italic font-weight-bold" for="proBrand">ProductBrand:</label>
<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand}" required>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proMadein">ProductMadein:</label>
<input type="text" class="form-control-sm" id="proMadein" name="proMadein"  value="${existingProduct.proMadein}"  required>
</div>

<div class="form-group">
<label class="font-italic font-weight-bold" for="proMfgDt">ProductMfgDt:</label>
<input type="date" class="form-control-sm" id="proMfgDt" name="proMfgDt" value="${existingProduct.proMfgDt}"  required>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proExpDt">ProductExpDt:</label>
<input type="date" class="form-control-sm" id="proExpDt" name="proExpDt"  value="${existingProduct.proExpDt}" required>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proImage">ProductImage:</label>
<input type="file" class="form-control-file-sm" id="proImage" name="proImage" accept="image/*" required>
</div>


<div>

<input type="submit" class="btn btn-success" value="save Product"/> 
<a href="productList.jsp" class="btn btn-primary"> ListofProduct </a>
</div>
</form>

<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validationForm()">



<!-- Display the current product image -->
<div class="form-group">
<label class="font-italic font-weight-bold" for="proId">Current Product Image</label>
<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage)}" alt="ProductImage" style="max-width:100px; max-height:100px;">

<input type="hidden" id="existingImage" name="existingImage" value="${existingProduct.proImage}"/>
</div>


<!-- Allow the user to update a new image -->
<div class="form-group">
<label class="font-italic font-weight-bold" for="proImage">ProductImage:</label>
<input type="file" class="form-control-file-sm" id="proImage" name="proImage" accept="image/*" required>
</div>



</form>
</div>
</body>
</html>