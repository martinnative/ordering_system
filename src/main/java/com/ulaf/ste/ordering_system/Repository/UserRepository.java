package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

}
