package com.worf.worf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCrontroller {
    @GetMapping("/health")
    public String getHealth(){
        return "Service is up.";
    }
}
