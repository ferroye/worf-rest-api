package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Status;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Wolf;
import com.worf.worf.service.exception.UnsupportedAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WolfProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(WolfProcessor.class);

    @Override
    public String process(Player source, Action action, Player target) {
//        this.getGame().
        if (source.getRole() instanceof Wolf) {
            switch (action) {
                case KILL:
                    target.setStatus(Status.INACTIVATING);
                    return "Done";
                default:
                    throw new UnsupportedAction("Action is not supported", null);
            }
        }
        return null;
    }
}
