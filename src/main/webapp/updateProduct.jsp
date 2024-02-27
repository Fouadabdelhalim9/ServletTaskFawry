<%@ page import="java.util.List" %>
<%--<%@ page import="com.example.productcatalog.model.Product" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String productId = request.getParameter("productId");
    String productName = request.getParameter("productName");
    String productPrice = request.getParameter("productPrice");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="products/update" method="post">
    <label>Name</label>
    <input type="hidden" name="productId" value="<%= productId %>">
    <input type="text" name="product-name" required value="<%= productName %>">
    <br>
    <br>
    <label>Price</label>
    <input type="text" name="product-price" required value="<%= productPrice %>" >
    <br>
    <br>
    <button type="submit" value="Update Product">Update</button>
</form>
</body>
</html>
