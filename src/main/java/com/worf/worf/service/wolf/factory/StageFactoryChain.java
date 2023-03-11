package com.worf.worf.service.wolf.factory;

import com.worf.worf.service.StageFactory;
import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.role.Player;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StageFactoryChain implements StageFactory {
    private List<StageFactory> stageFactoryChain;

    public StageFactoryChain(StageFactory villagerFactory,
                             StageFactory seerFactory,
                             StageFactory wolfFactory,
                             StageFactory witchFactory){
        this.stageFactoryChain = Arrays.asList(
                villagerFactory,
                seerFactory,
                wolfFactory,
                witchFactory);
    }

    @Override
    public StageProcessor createStage(Player player) {
    }
}
