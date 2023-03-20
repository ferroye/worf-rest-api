package com.worf.worf.service;

import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RoleActionProcessor {
    private Game game;
    public abstract void process(Player source, Action action, Player target);
}
