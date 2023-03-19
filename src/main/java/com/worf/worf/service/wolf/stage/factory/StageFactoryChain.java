package com.worf.worf.service.wolf.stage.factory;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Role;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StageFactoryChain implements StageFactory {
    private List<StageFactory> stageFactoryChain;

    public StageFactoryChain(StageFactory seerFactory,
                             StageFactory wolfFactory,
                             StageFactory witchFactory,
                             StageFactory chiefFactory) {
        this.stageFactoryChain = Arrays.asList(
                seerFactory,
                wolfFactory,
                witchFactory,
                chiefFactory);
    }

    @Override
    public StageProcessor createStage(Role role) {
        for (StageFactory stageFactory : stageFactoryChain) {
            StageProcessor stageProcessor = stageFactory.createStage(role);
            if (stageProcessor != null)
                return stageProcessor;
        }
        return null;
    }
}
