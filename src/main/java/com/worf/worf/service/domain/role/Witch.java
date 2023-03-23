package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Witch extends God{
    public Witch(){
        this.setRoleName(this.getClass().getSimpleName());
        List<Action> abilities = new ArrayList<>();
        abilities.add(Action.VOTE);
        abilities.add(Action.SAVE);
        abilities.add(Action.POISON);
        this.setAbilities(abilities);
        this.setPriority(Priority.WITCH);
    }
}
