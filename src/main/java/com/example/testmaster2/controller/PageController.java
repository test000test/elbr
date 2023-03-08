package com.example.testmaster2.controller;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.service.serviceImpl.ProductServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class PageController {
    private final ProductServiceImpl productService;

    @GetMapping("/")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
