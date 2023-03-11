package com.worf.worf.service.wolf.factory;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Wolf;

public class WolfFactory implements StageFactory {
    @Override
    public StageProcessor createStage(Player player) {
        return player.getRole() instanceof Wolf? new Wolf(player): null;
    }
}
