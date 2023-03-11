package com.worf.worf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

public class HealthCrontroller {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCrontroller.class);

    @GetMapping("health")
    public String getHealth(){
        LOGGER.info("Entered Health api.");
        return "Service is up.";
    }
}
