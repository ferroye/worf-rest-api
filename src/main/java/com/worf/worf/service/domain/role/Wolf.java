package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Ability;

import java.util.Arrays;

public class Wolf extends Role{

    public Wolf(){
        super.setAbilities(Arrays.asList(Ability.KILL,Ability.VOTE));
    }
}
