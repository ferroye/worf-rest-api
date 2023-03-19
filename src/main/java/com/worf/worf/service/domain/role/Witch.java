package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Action;

import java.util.Arrays;

public class Witch extends God{
    public Witch(){
        this.setRoleName(this.getClass().getSimpleName());
        this.setAbilities(Arrays.asList(Action.VOTE, Action.SAVE, Action.POISON));
    }
}
