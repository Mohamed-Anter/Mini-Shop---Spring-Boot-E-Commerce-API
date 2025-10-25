package com.example.minishop.controller;

import com.example.minishop.entity.Order;
import com.example.minishop.service.OrderService;
import org.springframework.web.bind.annotation.*;

/* Order endpoints */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/from-cart/{cartId}") public Order createFromCart(@PathVariable Long cartId) { return service.createFromCart(cartId); }
}
