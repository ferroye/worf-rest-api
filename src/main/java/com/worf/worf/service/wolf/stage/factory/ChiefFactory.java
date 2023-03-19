package com.worf.worf.service.wolf.stage.factory;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Chief;
import com.worf.worf.service.domain.role.Role;
import com.worf.worf.service.wolf.stage.processor.ChiefProcessor;
import org.springframework.stereotype.Component;

@Component
public class ChiefFactory implements StageFactory {
    @Override
    public StageProcessor createStage(Role role) {
        return role instanceof Chief ? new ChiefProcessor() : null;
    }
}
