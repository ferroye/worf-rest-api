package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Action;

import java.util.Arrays;

public class Villager extends Role{
    public Villager(){
        this.setRoleName(this.getClass().getSimpleName());
        super.setAbilities(Arrays.asList(Action.VOTE));
    }
}
