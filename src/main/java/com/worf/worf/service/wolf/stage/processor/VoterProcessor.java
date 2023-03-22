package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Status;
import com.worf.worf.service.domain.role.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class VoterProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(VoterProcessor.class);
    private int actionCount;

    @Override
    public String process(Player source, Action action, Player target) {
        LOGGER.info("Voter's turn.");
        if (this.getGame().isDayTime()) {
            LOGGER.info("Action count: {}", ++actionCount);
            if (actionCount == this.getGame().getPlayers().stream().filter(p -> p.getStatus() == Status.ACTIVE).count()) {
                return "Done";
            } else {
                return null;
            }
        }
        return null;
    }
}
