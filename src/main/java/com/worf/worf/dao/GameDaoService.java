package com.worf.worf.dao;

import com.worf.worf.entity.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("NoSQL")
public class GameDaoService implements GameDao{

    private static final Logger log = LoggerFactory.getLogger(GameDaoService.class);

    @Override
    public boolean createGame(Game game) {
        log.info("GameDaoService for NOSQL");
        return true;
    }

    @Override
    public boolean startGame(Game game) {
        return false;
    }
}
