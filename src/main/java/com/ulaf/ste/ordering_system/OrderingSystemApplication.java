package com.ulaf.ste.ordering_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "com.ulaf.ste.ordering_system.Model")
public class OrderingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderingSystemApplication.class, args);

    }

}
