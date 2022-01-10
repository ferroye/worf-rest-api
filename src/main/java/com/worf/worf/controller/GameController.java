package com.worf.worf.controller;

import com.worf.worf.entity.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @PostMapping("/create")
    public void createGame(@RequestBody Game game){
        //TODO: To be implemented.
        log.info("Creating a game.");
    }

}
