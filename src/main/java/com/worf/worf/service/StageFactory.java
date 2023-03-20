package com.worf.worf.service;

import com.worf.worf.service.domain.role.Role;

public interface StageFactory {
    RoleActionProcessor createStage(Role role);
}
