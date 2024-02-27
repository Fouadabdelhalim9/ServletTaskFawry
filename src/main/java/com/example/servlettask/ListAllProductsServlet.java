package com.example.servlettask;
import com.example.servlettask.model.Product;
import com.example.servlettask.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ListAllProductsServlet extends HttpServlet {
    ProductRepository productRepository = ProductRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> allProducts = productRepository.findProducts();
        System.out.println("All products in a DB :\n" + allProducts + '\n');
        if(!allProducts.isEmpty()){
            request.setAttribute("products", allProducts);
            request.getRequestDispatcher("/products.jsp").forward(request, response);
        }else{
            response.getWriter().println("No products available.");
        }
    }
}