package com.example.servlettask;
import com.example.servlettask.model.Product;
import com.example.servlettask.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/update")
public class UpdateProductServlet extends HttpServlet {
    private ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("product-name");
        double productPrice = Double.parseDouble(request.getParameter("product-price"));

        Product existingProduct = productRepository.findById(productId);
        System.out.println("The product you want to update:\n" + existingProduct + '\n');

        existingProduct.setName(productName);
        existingProduct.setPrice(productPrice);

        System.out.println("Products after updating : \n" + productRepository.findProducts() + '\n');

        response.sendRedirect("/products");
    }
}
