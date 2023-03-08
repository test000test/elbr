package com.example.testmaster2.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    Roles() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
