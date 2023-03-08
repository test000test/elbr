package com.example.testmaster2.controller;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.CartItem;
import com.example.testmaster2.entity.Product;
import com.example.testmaster2.entity.User;
import com.example.testmaster2.service.serviceImpl.CartServiceImpl;
import com.example.testmaster2.service.serviceImpl.ProductServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
public class CartController {
    private final ProductServiceImpl productService;
    private final CartServiceImpl cartService;

    @PostMapping("/addProductToCart/{id}")
    public ResponseEntity<Product> addProductToCart(@PathVariable Long id,
                                                    HttpServletRequest request,
                                                    @AuthenticationPrincipal User user) {
        HttpSession session = request.getSession();
        Product product = productService.findProductById(id);

        // Если корзины нет в сессии, создать ее и добавить продукт
        if (session.getAttribute("cart") == null) {
            Set<CartItem> cart = new HashSet<>();
            session.setMaxInactiveInterval(60 * 60 * 24);
            session.setAttribute("cart", cart);
            cart.add(new CartItem(1, product));

            // В ином случае найти созданную корзину в сессии и добавить продукт,
            // Если данный продукт есть, добавить +1 к кол-ву
        } else {
            Set<CartItem> cart = (Set<CartItem>) session.getAttribute("cart");

            // Поиск продукта в корзине
            CartItem itemCart = cart.stream()
                    .filter(f -> f.getProduct().getId().equals(product.getId()))
                    .findFirst()
                    .orElse(null);

            if (itemCart == null) {
                cart.add(new CartItem(1, product));
            } else {
                itemCart.setQty(itemCart.getQty() + 1);
            }
        }
        if (user != null) {
            Cart cart = user.getCart();
            Set<CartItem> sessionCart = (Set<CartItem>) session.getAttribute("cart");
            sessionCart.forEach(cartItem -> cartItem.setCart(cart));
            cart.setProducts(sessionCart);
            cartService.addProductToCart(cart, product);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Product product = productService.findProductById(id);
        Cart cart = user.getCart();
        cartService.removeProductFromCart(cart, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
