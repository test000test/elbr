package com.example.testmaster2.entity;

import com.example.testmaster2.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    @NotEmpty(message = "логин не должен быть пустым")
    @Size(min = 4, max = 20)
    private String username;

    @Column(name = "password", columnDefinition = "text")
    @NotEmpty(message = "пароль не должен быть пустым")
    @Size(min = 6)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
