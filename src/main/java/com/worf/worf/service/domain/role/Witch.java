package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Ability;

import java.util.Arrays;

public class Witch extends God{
    public Witch(Player player){
        this.setAbilities(Arrays.asList(Ability.VOTE,Ability.SAVE,Ability.POISON));
    }
}
