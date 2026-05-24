package com.example.E_commerce.service;

import com.example.E_commerce.model.Cart;
import com.example.E_commerce.repository.CartRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CartService {

    private final CartRepository repository;

    // ADD TO CART

    public Cart addToCart(Cart cart) {

        return repository.save(cart);
    }

    // GET USER CART

    public List<Cart> getUserCart(Long userId) {

        return repository.findByUserId(userId);
    }

    // REMOVE CART ITEM

    public String removeCartItem(Long id) {

        repository.deleteById(id);

        return "Cart Item Removed";
    }
}