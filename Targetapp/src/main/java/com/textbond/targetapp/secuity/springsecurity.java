package com.textbond.targetapp.secuity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class springsecurity{

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
            int[] a= new int[3];
        return http

                    .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth ->)
    }
}
