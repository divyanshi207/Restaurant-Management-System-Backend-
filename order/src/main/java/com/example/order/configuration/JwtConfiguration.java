package com.example.order.configuration;

import com.example.order.filter.JwtFilter;
import com.example.order.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtConfiguration {
    @Autowired
    JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws  Exception{
        httpSecurity
                .csrf(csrf->csrf.disable())
                .formLogin(f->f.disable())
                .httpBasic(head->head.disable())
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/order/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                )
                .headers(h->h.frameOptions
                        (fo->fo.sameOrigin()));
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
