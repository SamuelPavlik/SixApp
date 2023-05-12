package com.example.sixapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) throws InterruptedException {
        Product createdProduct = productService.createProduct(productDTO);
        Thread.sleep(200);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId) {
        return productService.getProduct(productId)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws InterruptedException {
        List<Product> products = productService.getAllProducts();
        Thread.sleep(300);
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") long productId, @RequestBody ProductDTO updatedProduct) {
        return productService.updateProduct(productId, updatedProduct)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
