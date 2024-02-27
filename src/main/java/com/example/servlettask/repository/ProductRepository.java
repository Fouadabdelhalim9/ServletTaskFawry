package com.example.servlettask.repository;
import com.example.servlettask.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {


    private int sequence = 1;

    List<Product> products = new ArrayList<>();

    private static volatile ProductRepository instance;

    private ProductRepository() {
        products.add(new Product(sequence++, "Product A", 100));
        products.add(new Product(sequence++, "Product B", 150));
        products.add(new Product(sequence++, "Product C", 170));
        products.add(new Product(sequence++, "Product D", 80));
        products.add(new Product(sequence++, "Product E", 120));
        products.add(new Product(sequence++, "Product F", 50));
        products.add(new Product(sequence++, "Product G", 150));
    }


    public static ProductRepository getInstance() {
        // double-checked locking
        if(instance == null) {
            synchronized (ProductRepository.class) {
                if (instance == null) {
                    instance = new ProductRepository();
                }
            }
        }
        return instance;
    }

    public List<Product> findProducts() {
        return products;
    }

    public void addProduct(Product product) {
        product.setId(sequence++);
        products.add(product);
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
