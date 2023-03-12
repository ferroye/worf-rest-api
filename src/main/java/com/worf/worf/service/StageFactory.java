package com.worf.worf.service;

import com.worf.worf.service.domain.role.Role;

public interface StageFactory {
    StageProcessor createStage(Role role);
}
