package com.worf.worf;

import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Seer;
import com.worf.worf.service.domain.role.Witch;
import com.worf.worf.service.domain.role.Wolf;
import com.worf.worf.service.wolf.GameManagerService;
import com.worf.worf.service.wolf.stage.StageFactoryChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

@SpringBootTest
class WorfApplicationTests {

    GameManagerService gameManagerService;
    @Autowired
    StageFactoryChain roleFactoryChain;

    @BeforeEach
    void init() {
        gameManagerService = new GameManagerService(roleFactoryChain);

    }

    @Test
    void contextLoads() throws IOException {
        Game game = new Game();
        Player a = new Player();
        a.setRole(new Seer());
        Player b = new Player();
        b.setRole(new Wolf());
        Player c = new Player();
        c.setRole(new Witch());
        Player d = new Player();
        d.setRole(new Witch());
        game.setPlayers(Arrays.asList(a, b, c, d));

//		Role role = new SeerFactory();
//		game.setRoles();
        gameManagerService.createGame(game);
        gameManagerService.initStage();
        gameManagerService.startGame();

//        assert gameManagerService.get
        System.out.println("Done");


    }


}
