package com.example.testmaster2.service;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.Product;
import com.example.testmaster2.entity.User;

import java.util.List;

public interface ProductService {
    Product addProductToShop(Product product, User user);
    List<Product> showAllProducts();
    Product findProductById(Long id);
}
