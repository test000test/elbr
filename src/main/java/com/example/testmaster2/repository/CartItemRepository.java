package com.example.testmaster2.repository;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
