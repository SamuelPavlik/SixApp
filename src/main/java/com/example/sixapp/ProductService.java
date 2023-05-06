package com.example.sixapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products;
    private long nextProductId;

    public ProductService() {
        this.products = new ArrayList<>();
        this.nextProductId = 1;
    }

    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(nextProductId++, productDTO);
        products.add(product);
        return product;
    }

    public Optional<Product> getProduct(long productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst();
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> updateProduct(long productId, ProductDTO updatedProduct) {
        Optional<Product> productToUpdate = products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst();

        if (productToUpdate.isPresent()) {
            Product product = productToUpdate.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            return Optional.of(product);
        }

        return Optional.empty();
    }

    public void deleteProduct(long productId) {
        products.removeIf(product -> product.getId() == productId);
    }

}

