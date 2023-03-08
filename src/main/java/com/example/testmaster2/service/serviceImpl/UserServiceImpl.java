package com.example.testmaster2.service.serviceImpl;

import com.example.testmaster2.entity.Cart;
import com.example.testmaster2.entity.User;
import com.example.testmaster2.enums.Roles;
import com.example.testmaster2.repository.CartRepository;
import com.example.testmaster2.repository.UserRepository;
import com.example.testmaster2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    // Login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    // Registration
    @Override
    public User RegistrationUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.ROLE_USER);
        user.setCart(cartRepository.save(new Cart()));
        return userRepository.save(user);
    }
}
