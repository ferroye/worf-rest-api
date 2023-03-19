package com.worf.worf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("wolf")
public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    @PostMapping("/{gameId}")
    public ResponseEntity<String> createGame() {


        return new ResponseEntity<>(
                "Success",
                HttpStatus.OK);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<String> startGame(@RequestParam String gameId) {
        LOGGER.info("start game");

        return new ResponseEntity<>(
                "Success",
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> action(@RequestParam String srcPlayerId, @RequestParam String action, @RequestParam String targetPlayerId){
        LOGGER.info("start game");
        return new ResponseEntity<>(
                "Success",
                HttpStatus.OK);
    }

}
