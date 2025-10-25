package com.example.minishop.controller;

import com.example.minishop.entity.Product;
import com.example.minishop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Product endpoints */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @PostMapping public Product create(@RequestBody Product p) { return service.save(p); }
    @GetMapping public List<Product> all() { return service.findAll(); }
    @GetMapping("/{id}") public Product get(@PathVariable Long id) { return service.find(id); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}
