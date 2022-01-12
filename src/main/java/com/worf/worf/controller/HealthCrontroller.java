package com.worf.worf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/health")
@RestController
public class HealthCrontroller {

    private static final Logger log = LoggerFactory.getLogger(HealthCrontroller.class);

    @GetMapping
    public String getHealth(){
        log.info("Entered Health api.");
        return "Service is up.";
    }
}
