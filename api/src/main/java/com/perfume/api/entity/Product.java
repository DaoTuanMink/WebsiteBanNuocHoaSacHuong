package com.perfume.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data // Thư viện Lombok tự sinh getter/setter
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String brand;
    
    private Double price;

    private String description;

    private Integer stock; // Số lượng hàng tồn kho
}