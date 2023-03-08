package com.example.testmaster2.service;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.Product;
import com.example.testmaster2.entity.User;

public interface CartService {
    void addProductToCart(Cart cart, Product product);
    void removeProductFromCart(Cart cart, Product product);
}
