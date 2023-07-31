package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Role;
import com.ulaf.ste.ordering_system.Model.User;
import com.ulaf.ste.ordering_system.Repository.UserRepository;
import com.ulaf.ste.ordering_system.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(String username,String password,String name, String surname, Role role) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username,name,surname,encodedPassword,role);
        return userRepository.save(user);
    }

    public String getRole(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user.getRole().toString(); // Assuming the role is stored in a field called "role" in the User entity
        }
        return null; // Return null or handle the case when the user is not found
    }

    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User update(String name, String surname, String username, String password, String role) {
        User member = new User(name,surname,username, passwordEncoder.encode(password), Role.valueOf(role));
        return userRepository.save(member);
    }
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        // Check if user exists and password is correct
        if (user != null && isPasswordValid(user, password)) {
            return user;
        }
        return null; // Authentication failed
    }

    public boolean isPasswordValid(User user, String password) {
        return true; //TODO:
    }

}