package com.example.E_commerce.service;

import com.example.E_commerce.model.Product;
import com.example.E_commerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository repository;

    // ADD PRODUCT

    public Product addProduct(Product product) {

        return repository.save(product);
    }

    // GET ALL PRODUCTS

    public List<Product> getAllProducts() {

        return repository.findAll();
    }

    // GET PRODUCT BY ID

    public Product getProductById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product Not Found")
                );
    }

    // UPDATE PRODUCT

    public Product updateProduct(Long id, Product product) {

        Product existingProduct =
                repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product Not Found")
                );

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setStock(product.getStock());

        return repository.save(existingProduct);
    }

    // DELETE PRODUCT

    public String deleteProduct(Long id) {

        repository.deleteById(id);

        return "Product Deleted Successfully";
    }
}