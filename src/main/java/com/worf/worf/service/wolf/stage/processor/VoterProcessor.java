package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.ActionProcessorStatus;
import com.worf.worf.service.domain.ActionResponse;
import com.worf.worf.service.domain.Status;
import com.worf.worf.service.domain.role.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class VoterProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(VoterProcessor.class);
    private Set<Integer> actedPlayer = new HashSet<>();

    @Override
    public ActionResponse process(Player source, Action action, Player target) {
        if (this.getGame().isDayTime()) {
            LOGGER.info("Voter's turn.");
            if(actedPlayer.contains(source.getPlayerId())){
                LOGGER.info("Action count: {}", actedPlayer.size());
                return new ActionResponse("Your vote has changed", ActionProcessorStatus.CONTINUE);
            }else if(!actedPlayer.contains(source.getPlayerId())){
                actedPlayer.add(source.getPlayerId());
                LOGGER.info("Action count: {}", actedPlayer.size());
            }
            if (actedPlayer.size() == this.getGame().getPlayers().stream().filter(p -> p.getStatus() == Status.ACTIVE).count()) {
                actedPlayer.clear();
                return new ActionResponse("Done", ActionProcessorStatus.DONE);
            }
        }
        return null;
    }

}
