package com.example.testmaster2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cart_item")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem {
//    @EmbeddedId
//    @JsonIgnore
//    private CartItemPK pk;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer qty;

    public CartItem(Integer qty, Cart cart, Product product) {
        this.qty = qty;
        this.cart = cart;
        this.product = product;
    }

    public CartItem(Integer qty, Product product) {
        this.qty = qty;
        this.product = product;
    }

    //    public CartItem(Cart cart, Product product, Integer qty) {
//        pk = new CartItemPK();
//        pk.setCart(cart);
//        pk.setProduct(product);
//        this.qty = qty;
//    }
//
//    @Transient
//    public Product getProduct() {
//        return this.pk.getProduct();
//    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cart cart;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQty();
    }
}
