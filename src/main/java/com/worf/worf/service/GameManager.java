package com.worf.worf.service;

import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.Player;

public interface GameManager {

    void initStage();
    boolean isGameOver();
    void createGame(Game game);
    void endGame();
    void startGame();
    void processStage();
    void processAction(Player source, Action action, Player target);


}
