package com.example.sixapp;

import java.math.BigDecimal;

public class ProductDTO {

    public ProductDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    private final String name;
    private final BigDecimal price;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
