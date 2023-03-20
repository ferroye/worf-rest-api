package com.worf.worf.service.wolf;

import com.worf.worf.service.GameManager;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.*;
import com.worf.worf.service.wolf.stage.processor.RoleActionChain;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WolfGameManager implements GameManager {
    Logger LOGGER = LoggerFactory.getLogger(WolfGameManager.class);

    private Game game;
    private boolean hasStarted;
    private final RoleActionChain roleActionChain;


    @Override
    public void processStage() {
        // enter night.
        if (this.isGameOver()) {
            LOGGER.info("Game over!!");
        } else {
            if (this.game.getStages().size() == this.game.getTotalStagesCount()) {
                LOGGER.info("--------------------");
                LOGGER.info("Entering night time");
                this.game.setDayTime(false);
                this.game.setCurRoleActionStage(this.game.getStages().poll());
                LOGGER.info("-------{}-------, stage left:{}", this.game.getCurRoleActionStage().getRoleName(), this.game.getStages().size());
            } else if (this.game.getStages().isEmpty()) {
                //refresh stage for next night.
                LOGGER.info("Entering day time");
                LOGGER.info("--------------------");
                this.initStage();
                this.game.setCurRoleActionStage(null);
                this.game.setDayTime(true);
            } else {
                this.game.setCurRoleActionStage(this.game.getStages().poll());
                LOGGER.info("-------{}-------, stage left:{}", this.game.getCurRoleActionStage().getRoleName(), this.game.getStages().size());
            }
        }
    }

    @Override
    public void processRoleAction(Player source, Action action, Player target) {
        if (!this.hasStarted || this.isGameOver())
            return;

        if (this.game.isDayTime()) {
            LOGGER.info("Day time action only.");
        } else if (!this.game.getCurRoleActionStage().getRoleName().equals(source.getRole().getRoleName())) {
            LOGGER.info("Not your turn.");
        } else if (!source.getRole().getAbilities().contains(action)) {
            LOGGER.info("You do not have this ability");
        } else {
            roleActionChain.process(source,action,target);
            this.processStage();
        }

    }

    @Override
    public void initStage() {
        LOGGER.info("init stages.");
        game.setStages(new LinkedList<>());
        for (Role role : game.getPlayers().stream().map(Player::getRole).distinct().collect(Collectors.toList())) {
            game.getStages().add(role);
        }
//        adding additonal stage as needed
//        if (this.game.isHasChief()) {
//            game.getStages().add(new Chief());
//        }
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
    public String createGame(Game game) {
        LOGGER.info("Create game.");
        this.game = game;
        this.hasStarted = false;
        this.game.setId(UUID.randomUUID().toString());
        return this.game.getId();
    }

    @Override
    public void endGame() {
        LOGGER.info("Stop game.");
        this.game = null;
        this.hasStarted = false;
    }

    @Override
    public void startGame() {
        LOGGER.info("Start game.");
        if (this.hasStarted) {
            LOGGER.info("Game has already started.");
            return;
        }
        this.initStage();
        this.roleActionChain.setGame(this.game);
        this.game.setTotalStagesCount(this.game.getStages().size());
        this.hasStarted = true;
        this.processStage();
    }


}
