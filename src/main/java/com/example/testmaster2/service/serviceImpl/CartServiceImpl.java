package com.example.testmaster2.service.serviceImpl;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.CartItem;
import com.example.testmaster2.entity.Product;
import com.example.testmaster2.repository.CartRepository;
import com.example.testmaster2.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public void addProductToCart(Cart cart, Product product) {

        // Поиск продукта в корзине
        CartItem itemCart = cart.getProducts().stream()
                .filter(f -> f.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

//        cart.setTotalItem(cart.getNumberOfProducts());
        cart.setTotalSum(cart.totalSum());
        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(Cart cart, Product product) {
        // Поиск продукта в корзине
        CartItem itemCart = cart.getProducts().stream()
                .filter(f -> f.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        // Если количество продукта в корзине 1 или меньше, то удалить его, в ином случае -1
        if (itemCart.getQty() <= 1) {
            cart.getProducts().remove(itemCart);
        } else {
            itemCart.setQty(itemCart.getQty() - 1);
        }
        cart.setTotalItem(cart.getTotalItem() - 1);
        cart.setTotalSum(cart.totalSum());
        cartRepository.save(cart);
    }
}
