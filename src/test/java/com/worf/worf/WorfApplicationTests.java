package com.worf.worf;

import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.WinCondition;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Seer;
import com.worf.worf.service.domain.role.Witch;
import com.worf.worf.service.domain.role.Wolf;
import com.worf.worf.service.wolf.WolfGameManager;
import com.worf.worf.service.wolf.stage.processor.RoleActionChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class WorfApplicationTests {

    WolfGameManager wolfGameManager;

    @Autowired
    RoleActionChain roleActionChain;

    @BeforeEach
    void init() {
        wolfGameManager = new WolfGameManager(roleActionChain);
    }

    @Test
    void contextLoads() {
        Game game = new Game();
        Player seer = new Player();
        seer.setRole(new Seer());
        Player wolf = new Player();
        wolf.setRole(new Wolf());
        Player witch = new Player();
        witch.setRole(new Witch());
        Player d = new Player();
        d.setRole(new Witch());
        d.setRole(new Witch());

        game.setPlayers(Arrays.asList(seer, wolf, witch, d));
        game.setHasChief(true);
        game.setWinCondition(WinCondition.CATCH_ALL_WOLF);

        wolfGameManager.createGame(game);
        wolfGameManager.startGame();
        wolfGameManager.processRoleAction(seer, Action.INSPECT, witch);
        wolfGameManager.processRoleAction(witch, Action.POISON, witch);
        wolfGameManager.processRoleAction(wolf, Action.KILL, seer);
        wolfGameManager.processRoleAction(witch, Action.SAVE, witch);
        System.out.println("*********************");
        wolfGameManager.processStage();
        wolfGameManager.processRoleAction(wolf, Action.KILL, witch);
    }


}
