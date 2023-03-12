package com.worf.worf.service.wolf.stage;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Role;
import com.worf.worf.service.domain.role.Witch;
import com.worf.worf.service.wolf.processor.WitchProcessor;
import org.springframework.stereotype.Component;

@Component
public class WitchFactory implements StageFactory {
    @Override
    public StageProcessor createStage(Role role) {
        return role instanceof Witch ? new WitchProcessor() : null;
    }
}
