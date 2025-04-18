package com.example.demo.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class ConfigurationCla {
//
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
//	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin()  // Enable form-based authentication
            .and()
            .httpBasic(); // Enable basic authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEnco ) {
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEnco.encode("admin123"))
            .roles("ADMIN")  // Internally stored as ROLE_ADMIN
            .build();

        UserDetails user = User.builder()
            .username("user")
            .password(passwordEnco.encode("user123"))
            .roles("USER")  // Internally stored as ROLE_USER
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
