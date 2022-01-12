package com.worf.worf.service;

import com.worf.worf.dao.GameDao;
import com.worf.worf.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameDao gameDao;

    @Autowired
    public GameService(@Qualifier("NoSQL") GameDao gameDao){
        this.gameDao = gameDao;
    }
    public boolean createGame(Game game){
        return this.gameDao.createGame(game);
    }
}
