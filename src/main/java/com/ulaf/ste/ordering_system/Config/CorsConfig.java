package com.ulaf.ste.ordering_system.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://www.ulaf-ste.com","https://www.ulaf-ste.com","http://ulaf-ste.com","https://ulaf-ste.com","http://localhost:4200")); // Adjust the allowed origin for your frontend app
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Specify the allowed HTTP methods
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Specify allowed headers

        // You can also configure additional settings, such as max age and expose headers
        configuration.setMaxAge(3600L); // Max age of the CORS pre-flight request
        configuration.setExposedHeaders(List.of("Authorization")); // Expose the Authorization header to the frontend

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}


