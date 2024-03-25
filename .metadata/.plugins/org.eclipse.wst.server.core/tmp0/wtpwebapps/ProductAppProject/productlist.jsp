<%@page import="com.sathya.product.ProductDao" import="java.util.Base64"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div> 
  <h1 class="text-center text-success">LIST OF PRODUCTS</h1>
</div>

<div>
<a class="btn btn-success" href="add-product.html" >Save Product</a>
</div>

<div>
<input type="text" placeholder="Search">
</div>

<div>
<c:if test="${saveResult==1 }">
<h1 class="text-success text-center">Data Inserted Successfully</h1>
</c:if>
</div>

<div>
<c:if test="${deleteResult==1 }">
<h1 class="text-danger text-center">Data Deleted Successfully</h1>
</c:if>
</div>

<div>
<c:if test="${deleteResult==0 }">
<h1 class="text-danger text-center">Data Deletion Fail</h1>
</c:if>
</div>
 
  
  
<table class="table table-bordered table-striped">
<thead class="thead-dark">
       <tr>
           <th>ProductID</th>
           <th>ProductName</th>
           <th>ProductCost</th>
           <th>Brand</th>
           <th>Made IN</th>
           <th>Manufacturing date</th>
           <th>ExpiryDate</th>
           <th>Image</th>
           <th>Audio</th>
           <th>Video</th>
           <th>Actions</th>
       </tr>
</thead>
<tbody>
       <c:forEach var="product" items="<%=new ProductDao().findAll() %>">
            <tr>
                <td>${product.proId}</td>
                <td>${product.proName}</td>
                <td>${product.proPrice}</td>
                <td>${product.proBrand}</td>
                <td>${product.proMadeIn}</td>
                <td>${product.proMfgDate}</td>
                <td>${product.proExpDate}</td>
                <td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="ProductImage" style="max-width:100px; max-height:100px;">
                
                </td>
                <td> 
                <audio controls><source src="data:audio/jpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}" type="audio/mp3" >
                </audio>
                </td>
				<td>
   				<video controls width="320" height="240"><source src="data:video/jpeg;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4"> 
    			</video>
				</td>
                <td><a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId }">Delete</a>
                    <a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId }">Edit</a>
            </tr>
     	</c:forEach>
</tbody>
</table>
</body>
</html>