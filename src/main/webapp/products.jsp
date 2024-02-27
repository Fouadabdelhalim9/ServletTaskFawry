<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettask.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>

<html>
<head>
    <title>Products Page</title>
    <style>
        .action-buttons {
            margin-top: 8px;
        }
    </style>
</head>
<body>
<h1>All Products</h1>

<% for (Product product : products) { %>
<div>
    <span>Product Name: <%= product.getName() %></span>
    <br>
    <span>Product Price: <%= product.getPrice() %></span>
    <div class="action-buttons">
        <form method="post" action="/updateProduct.jsp">
            <input type="hidden" name="productId" value="<%= product.getId() %>">
            <input type="hidden" name="productName" value="<%= product.getName() %>">
            <input type="hidden" name="productPrice" value="<%= product.getPrice() %>">
            <button type="submit">Update</button>
        </form>

        <form method="post" action="/products/delete">
            <input type="hidden" name="productId" value="<%= product.getId() %>">
            <button type="submit">Delete</button>
        </form>
    </div>
</div>
<% } %>

<form method="post" action="/addProduct.jsp">
    <button type="submit">Add New Product</button>
</form>

</body>
</html>
