package com.example.minishop.controller;

import com.example.minishop.entity.Cart;
import com.example.minishop.entity.User;
import com.example.minishop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get cart by user ID
    @GetMapping("/{userId}")
    public Cart getCartByUser(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    // Add product to cart
    @PostMapping("/{userId}/add/{productId}")
    public Cart addProductToCart(@PathVariable Long userId, @PathVariable Long productId) {
        return cartService.addProductToCart(userId, productId);
    }


    // Remove product from cart
    @DeleteMapping("/{userId}/remove/{productId}")
    public Cart removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        return cartService.removeProductFromCart(userId, productId);
    }

    // Clear cart
    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
    }
}
