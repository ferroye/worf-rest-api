package com.worf.worf.service;

import com.worf.worf.service.domain.role.Player;

public interface StageFactory {
    StageProcessor createStage(Player player);
}
