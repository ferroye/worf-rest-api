package com.worf.worf.service.wolf;

import com.worf.worf.service.GameManager;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.*;
import com.worf.worf.service.wolf.stage.StageFactoryChain;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameManagerService implements GameManager {
    private Game game;
    private boolean hasStarted;
    private List<StageProcessor> handlers;
    private final StageFactoryChain stageFactoryChain;

    Logger LOGGER = LoggerFactory.getLogger(GameManagerService.class);

    @Override
    public void processStage() {
        LOGGER.info("process stage.");
        for(StageProcessor stageProcessor: handlers){
            stageProcessor.process(game);
        }
    }


    @Override
    public void processAction(Player source, Action action, Player target) {
        LOGGER.info("process action.");
    }

    @Override
    public void initStage() {
        LOGGER.info("init Stage.");
        handlers = new ArrayList<>();
        for (Role role : game.getPlayers().stream().map(Player::getRole).distinct().collect(Collectors.toList())) {
            handlers.add(stageFactoryChain.createStage(role));
        }
    }

    @Override
    public boolean isGameOver() {
        LOGGER.info("Checking Game status");

        if (!hasStarted || game == null)
            return false;

        switch (game.getWinCondition()) {
            case CATCH_ALL_WOLF:
                return this.game.getPlayers().stream().noneMatch(player -> player.getRole() instanceof Wolf);
            case KILL_ALL:
                return this.game.getPlayers().stream().allMatch(player -> player.getRole() instanceof Wolf);
            case KILL_ALL_CIVILIANS_OR_ALL_GOOD:
                return !this.game.getPlayers().stream().allMatch(player -> player.getRole() instanceof Villager) ||
                        !this.game.getPlayers().stream().allMatch(player -> player.getRole() instanceof God);
            case KILL_ALL_CIVILIANS_OR_ALL_GOOD_AND_FOOL_MUST_DIE:
                return this.game.getPlayers().stream().noneMatch(player -> player.getRole() instanceof Villager) &&
                        this.game.getPlayers().stream().noneMatch(player -> player.getRole() instanceof Fool);
            default:
                break;
        }
        return false;
    }

    @Override
    public void createGame(Game game) {
        LOGGER.info("Create game.");

        this.game = game;
        this.hasStarted = false;

    }

    @Override
    public void endGame() {
        LOGGER.info("Stop game.");
        this.game = null;
        this.hasStarted = false;
        this.handlers = null;
    }

    @Override
    public void startGame() {
        LOGGER.info("Start game.");

        this.hasStarted = true;
        this.processStage();
    }


}
