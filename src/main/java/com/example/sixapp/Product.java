package com.example.sixapp;

import java.math.BigDecimal;

public class Product {

    private final Long id;
    private String name;
    private BigDecimal price;

    public Product(Long id, ProductDTO productDTO) {
        this.id = id;
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
    }

    public final Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
