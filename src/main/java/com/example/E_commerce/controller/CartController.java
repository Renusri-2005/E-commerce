package com.example.E_commerce.controller;

import com.example.E_commerce.model.Cart;
import com.example.E_commerce.service.CartService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartService service;

    // ADD TO CART

    @PostMapping("/add")

    public Cart addToCart(
            @RequestBody Cart cart
    ) {

        return service.addToCart(cart);
    }

    // GET USER CART

    @GetMapping("/{userId}")

    public List<Cart> getUserCart(
            @PathVariable Long userId
    ) {

        return service.getUserCart(userId);
    }

    // REMOVE CART ITEM

    @DeleteMapping("/{id}")

    public String removeCartItem(
            @PathVariable Long id
    ) {

        return service.removeCartItem(id);
    }
}
