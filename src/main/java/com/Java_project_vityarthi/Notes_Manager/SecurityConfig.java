package com.Java_project_vityarthi.Notes_Manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // 1. Allow the background image and Bootstrap to load without logging in
                .requestMatchers("/user_login.png").permitAll() 
                // 2. Any other page requires a login
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                // 3. Tell Spring to use our custom login.html
                .loginPage("/login") 
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}