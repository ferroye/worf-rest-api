package com.worf.worf.service.wolf.processor.stage;

import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StageProcessorChain {
    private List<StageProcessor> stageProcessors;
    public StageProcessorChain(Game game){
//        each night.
//        seer, wolf, witch,
        stageProcessors = new ArrayList<>();

        for(Role role: game.getRoles().stream().distinct().collect(Collectors.toList())){
//            if(role instanceof Seer){
//                stageProcessHandlers.add()
//            }else if(role instanceof Wolf){
//
//            }
        }
    }
}
