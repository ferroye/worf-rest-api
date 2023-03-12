package com.worf.worf.service.wolf.stage;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Role;
import com.worf.worf.service.domain.role.Seer;
import com.worf.worf.service.wolf.processor.SeerProcessor;
import org.springframework.stereotype.Component;

@Component
public class SeerFactory implements StageFactory {
    @Override
    public StageProcessor createStage(Role role) {
        return role instanceof Seer ?  new SeerProcessor(): null;
    }
}
