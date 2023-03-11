package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Ability;

import java.util.Arrays;

public class Villager extends Role{
    public Villager(Player player){
        super.setAbilities(Arrays.asList(Ability.VOTE));
    }
}
