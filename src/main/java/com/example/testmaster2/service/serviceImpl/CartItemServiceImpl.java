package com.example.testmaster2.service.serviceImpl;

import com.example.testmaster2.entity.CartItem;
import com.example.testmaster2.repository.CartItemRepository;
import com.example.testmaster2.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem findCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public CartItem saveItem(CartItem item) {
        return cartItemRepository.save(item);
    }
}
