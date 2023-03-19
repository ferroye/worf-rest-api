package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Action;

import java.util.Arrays;

public class Chief extends Role{
    public Chief(){
        super.setAbilities(Arrays.asList(Action.EXTRA_VOTE));
    }
}
