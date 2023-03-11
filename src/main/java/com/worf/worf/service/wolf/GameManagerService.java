package com.worf.worf.service.wolf;

import com.worf.worf.service.GameManager;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameManagerService implements GameManager {
    private Game game;
    private boolean hasStarted;
    private List<StageProcessor> handlers;

    @Override
    public void initStage() {
        handlers = Arrays.asList();
    }

    @Override
    public boolean isGameOver() {
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
        this.game = game;
        this.hasStarted = false;
    }

    @Override
    public void endGame() {
        this.game = null;
        this.hasStarted = false;
    }

    @Override
    public void startGame() {
        this.hasStarted = true;
        processStage();
    }

    @Override
    public void processStage() {
//        create all the roles.
//get all the roles and create the process.
    }


    @Override
    public void processAction(Player source, Action action, Player target) {

    }
}
