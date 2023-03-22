package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Seer;
import com.worf.worf.service.domain.role.Wolf;
import com.worf.worf.service.exception.UnsupportedAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SeerProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(SeerProcessor.class);

    @Override
    public String process(Player source, Action action, Player target) {
        if (source.getRole() instanceof Seer) {
            switch (action) {
                case INSPECT:
                    return target.getRole() instanceof Wolf ?
                            "Wolf" : "Good";
                default:
                    throw new UnsupportedAction("Action is not supported", null);
            }
        }
        return null;
    }
}
