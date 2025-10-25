package com.example.minishop.repository;

import com.example.minishop.entity.Cart;
import com.example.minishop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser(User user);
}
