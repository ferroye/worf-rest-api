package com.worf.worf;

import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.WinCondition;
import com.worf.worf.service.domain.role.*;
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
    void normalGame() {
        Game game = new Game();
        Player seer = new Player();
        seer.setPlayerId(0);
        seer.setRole(new Seer());
        Player wolf = new Player();
        wolf.setPlayerId(1);
        wolf.setRole(new Wolf());
        Player witch = new Player();
        witch.setPlayerId(2);
        witch.setRole(new Witch());
        Player villager = new Player();
        villager.setRole(new Villager());
        villager.setPlayerId(3);

        game.setPlayers(Arrays.asList(seer, wolf, witch, villager));
        game.setHasChief(true);
        game.setWinCondition(WinCondition.CATCH_ALL_WOLF);

        wolfGameManager.createGame(game);
        wolfGameManager.startGame();
        wolfGameManager.processRoleAction(seer, Action.INSPECT, witch);
        wolfGameManager.processRoleAction(witch, Action.POISON, witch);
        wolfGameManager.processRoleAction(wolf, Action.KILL, seer);
        wolfGameManager.processRoleAction(witch, Action.SAVE, witch);

        wolfGameManager.processRoleAction(wolf, Action.VOTE, witch);
        wolfGameManager.processRoleAction(seer, Action.VOTE, witch);
    }


}
