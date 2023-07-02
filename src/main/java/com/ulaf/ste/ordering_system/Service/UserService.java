package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User update(String name, String surname, String username, String password, String role);

}
