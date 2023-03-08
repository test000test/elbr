//package com.example.testmaster2.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.io.Serializable;
//
//@Embeddable
//@Getter
//@Setter
//@EqualsAndHashCode
//public class CartItemPK implements Serializable {
//
//    @JsonBackReference
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Cart cart;
//
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private Product product;
//
//}
