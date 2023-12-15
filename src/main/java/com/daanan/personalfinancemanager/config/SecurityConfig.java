package com.daanan.personalfinancemanager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password_hash, enabled from user where username=?"
        );

        // Since authorities are not being used, authorities are set to empty in the query
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, 'NO_AUTHORITIES' as authority from user where username=?"
        );

        return jdbcUserDetailsManager;
    }

    // Configure security of web paths in application, login, logout, etc.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/register").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/loginProcessing")
                                .defaultSuccessUrl("/home", true)
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder( ) {

        return new BCryptPasswordEncoder();
    }
}







