package com.example.testmaster2.service.serviceImpl;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.Product;
import com.example.testmaster2.entity.User;
import com.example.testmaster2.repository.ProductRepository;
import com.example.testmaster2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    // Add product
    @Override
    public Product addProductToShop(Product product, User user) {
        product.setSeller(user);
        return productRepository.save(product);
    }

    // Show all products
    @Override
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }

    // Find product by id
    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}