package com.ulaf.ste.ordering_system.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatchers((matchers) -> matchers
                        .requestMatchers("/")
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .and()
//                .formLogin()
//                .failureUrl("/login?error=BadCredentials")
//                .defaultSuccessUrl("/",true)
//                .and()
//                .logout().logoutUrl("/logout").clearAuthentication(true)
//                .invalidateHttpSession(true).deleteCookies("JSESSIONID");
//
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**","/img/**","/lib/**","/h2/**");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(databaseAuthenticationProvider);
//    }


}
