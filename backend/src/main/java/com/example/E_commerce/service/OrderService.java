package com.example.E_commerce.service;

import com.example.E_commerce.model.Order;
import com.example.E_commerce.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {

    private final OrderRepository repository;

    // PLACE ORDER

    public Order placeOrder(Order order) {

        order.setCreatedAt(LocalDateTime.now());

        order.setStatus("PLACED");

        return repository.save(order);
    }

    // GET USER ORDERS

    public List<Order> getUserOrders(Long userId) {

        return repository.findByUserId(userId);
    }
}