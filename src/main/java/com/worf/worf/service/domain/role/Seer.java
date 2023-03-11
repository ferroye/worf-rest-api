package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Ability;

import java.util.Arrays;

public class Seer extends God {
    public Seer(Player player){
        super.setAbilities(Arrays.asList(Ability.VOTE,Ability.INSPECT));
    }
}
