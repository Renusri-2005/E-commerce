package com.example.E_commerce.controller;
import com.example.E_commerce.model.Product;
import com.example.E_commerce.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product addProduct(
            @RequestBody Product product
    ) {
        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {

        return service.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {

        service.deleteProduct(id);
    }
}