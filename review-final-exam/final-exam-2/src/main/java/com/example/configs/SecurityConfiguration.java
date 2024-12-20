package com.example.configs;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers("/", "/index", "/home").permitAll()
                        .requestMatchers("/report2").hasRole(ADMIN_ROLE)
                        .requestMatchers("/report1", "/customers", "/find-accounts-balance", "/detail/").hasRole(USER_ROLE)
                        .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder auth, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        UserDetails ud_user = User.builder()
                .username("user")
                .password(bCryptPasswordEncoder.encode("user"))
                .roles(USER_ROLE)
                .build();
        UserDetails ud_admin = User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder.encode("admin"))
                .roles(ADMIN_ROLE)
                .build();
        auth.inMemoryAuthentication().withUser(ud_user).withUser(ud_admin);

    }
}
