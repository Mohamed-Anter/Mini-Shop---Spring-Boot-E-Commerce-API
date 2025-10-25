package com.example.minishop.service;

import com.example.minishop.entity.Product;
import com.example.minishop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/* Product service */
@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }
    public Product save(Product p) { return repo.save(p); }
    public List<Product> findAll() { return repo.findAll(); }
    public Product find(Long id) { return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found")); }
    public void delete(Long id) { repo.deleteById(id); }
}
