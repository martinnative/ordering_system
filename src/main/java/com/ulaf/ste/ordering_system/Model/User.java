package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users_table")
public class User implements UserDetails {
    @Id
    private String username;
    private String name;
    private String surname;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    // Private constructor, use the builder to create instances of User
    public User(String username, String name, String surname, String password, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    // Builder class for User
    public static class Builder {
        private String username;
        private String name;
        private String surname;
        private String password;
        private Role role;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(username, name, surname, password, role);
        }
    }

    // Factory method to create a new builder instance
    public static Builder builder() {
        return new Builder();
    }

    // Implement UserDetails methods
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }
}
