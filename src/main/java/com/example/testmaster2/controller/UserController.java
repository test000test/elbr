package com.example.testmaster2.controller;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.Product;
import com.example.testmaster2.entity.User;
import com.example.testmaster2.service.serviceImpl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final ProductServiceImpl productService;

    // Add product to shop
    @PostMapping("/addProductToShop")
    public ResponseEntity<Product> addProductToShop(@RequestBody Product product, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok().body(productService.addProductToShop(product, user));
    }

    // Show all products
    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> showAllProducts() {
        return ResponseEntity.ok().body(productService.showAllProducts());
    }
}
