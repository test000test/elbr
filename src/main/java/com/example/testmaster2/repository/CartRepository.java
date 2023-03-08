package com.example.testmaster2.repository;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
