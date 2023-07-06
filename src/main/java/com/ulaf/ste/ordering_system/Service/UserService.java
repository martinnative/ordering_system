package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Role;
import com.ulaf.ste.ordering_system.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User update(String name, String surname, String username, String password, String role);
    User authenticate(String username, String password);
    boolean isPasswordValid(User user, String password);
    User save(String username,String password,String name, String surname, Role role);
    String getRole(String username);

}
