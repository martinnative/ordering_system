package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Model.Role;
import com.ulaf.ste.ordering_system.Model.User;
import com.ulaf.ste.ordering_system.Repository.UserRepository;
import com.ulaf.ste.ordering_system.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User update(String name, String surname, String username, String password, String role) {
        User member = new User(name,surname,username, passwordEncoder.encode(password), Role.valueOf(role));
        return userRepository.save(member);
    }
}
