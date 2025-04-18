package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Services;

@RestController
@RequestMapping("/secure")

public class ControllerCla {

	@Autowired
	Services serv;
	public ControllerCla(Services serv) {
		// TODO Auto-generated constructor stub
		 this.serv = serv;
	}
    
    
    @GetMapping("/user")
    public String userEndpoint() {
    	
        return serv.userAccess();
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return serv.adminAccess();
    }

    @GetMapping("/common")
    public String commonEndpoint() {
        return serv.commonAccess();
    }
    
	
}
