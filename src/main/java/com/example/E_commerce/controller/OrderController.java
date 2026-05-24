package com.example.E_commerce.controller;

import com.example.E_commerce.model.Order;
import com.example.E_commerce.service.OrderService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService service;

    // PLACE ORDER

    @PostMapping

    public Order placeOrder(
            @RequestBody Order order
    ) {

        return service.placeOrder(order);
    }

    // GET USER ORDERS

    @GetMapping("/{userId}")

    public List<Order> getUserOrders(
            @PathVariable Long userId
    ) {

        return service.getUserOrders(userId);
    }
}