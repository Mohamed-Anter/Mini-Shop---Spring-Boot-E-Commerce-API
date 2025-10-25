package com.example.minishop.service;

import com.example.minishop.entity.*;
import com.example.minishop.repository.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final CartRepository cartRepo;

    public OrderService(OrderRepository orderRepo, CartRepository cartRepo) {
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
    }

    public Order createFromCart(Long cartId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Order order = new Order();
        order.setUser(cart.getUser());
        order.setItems(new ArrayList<>());
        double total = 0;

        for (CartItem ci : cart.getItems()) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getQuantity());
            oi.setPrice(ci.getProduct().getPrice());
            order.getItems().add(oi);
            total += oi.getPrice() * oi.getQuantity();
        }

        order.setTotal(total);
        return orderRepo.save(order);
    }
}
