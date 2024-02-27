package com.example.servlettask;
import com.example.servlettask.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/delete")
public class DeleteProductServlet extends HttpServlet {
    private ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        productRepository.deleteProduct(productId);

        System.out.println("Products after deletion : \n" + productRepository.findProducts() + '\n');

        response.sendRedirect("/products");
    }
}
