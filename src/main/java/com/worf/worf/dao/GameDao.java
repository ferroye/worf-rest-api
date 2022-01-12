package com.worf.worf.dao;

import com.worf.worf.entity.Game;

/**
 * use it a Dependency injection purposes, later add service to implement the dao
 */
public interface GameDao {

    //TODO: list of Roles
    boolean createGame(Game game);

    boolean startGame(Game game);

}
