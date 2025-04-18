package com.example.demo.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class Services {

	@PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "Hello, User! You have USER access.";
    }

	@PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Hello, Admin! You have ADMIN access.";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String commonAccess() {
        return "Hello! Both ADMIN and USER can access this.";
    }
	
	
}
