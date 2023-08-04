package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.User;
import com.ulaf.ste.ordering_system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user information from the database based on the given username
        // Replace 'UserEntity' with your actual user entity class
       User userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Create and return a UserDetails object with the user information
        return User.builder()
                .withUsername(username)
                .withPassword(userEntity.getPassword()) // Make sure to store hashed passwords in the database
                .withRole(userEntity.getRole())
                .build();
    }
}

