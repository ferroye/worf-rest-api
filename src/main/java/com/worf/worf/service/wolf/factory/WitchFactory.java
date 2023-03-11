package com.worf.worf.service.wolf.factory;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Witch;

public class WitchFactory implements StageFactory {
    @Override
    public StageProcessor createStage(Player player) {
        return player.getRole() instanceof Witch? new Witch(player) : null;
    }
}
