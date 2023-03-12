package com.worf.worf.service.wolf.stage;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Role;
import com.worf.worf.service.domain.role.Wolf;
import com.worf.worf.service.wolf.processor.WolfProcessor;
import org.springframework.stereotype.Component;

@Component
public class WolfFactory implements StageFactory {
    @Override
    public StageProcessor createStage(Role role) {
        return role instanceof Wolf ? new WolfProcessor() : null;
    }
}
