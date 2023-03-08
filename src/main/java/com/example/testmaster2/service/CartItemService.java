package com.example.testmaster2.service;

import com.example.testmaster2.entity.CartItem;

public interface CartItemService {
    CartItem findCartItemById(Long id);

    CartItem saveItem(CartItem item);
}
