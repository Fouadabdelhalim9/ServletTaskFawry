<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Page</title>
</head>
<body>
    <form action="products/add" method="post" >
        <label>Name</label>
        <input type="text" name="product-name" required>
        <br>
        <br>
        <label>Price</label>
        <input type="text" name="product-price" required>
        <br>
        <br>
        <button type="submit" value="Add Product">Add</button>
    </form>
</body>
</html>
