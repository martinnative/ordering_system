package com.ulaf.ste.ordering_system.Model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SHOP_MANAGER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}