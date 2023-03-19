package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Action;

import java.util.Arrays;

public class Wolf extends Role{

    public Wolf(){
        this.setRoleName(this.getClass().getSimpleName());
        super.setAbilities(Arrays.asList(Action.KILL, Action.VOTE));
    }
}
