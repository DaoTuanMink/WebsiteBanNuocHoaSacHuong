package com.perfume.api.controller;

import com.perfume.api.entity.Product;
import com.perfume.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // API lấy danh sách toàn bộ nước hoa
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}