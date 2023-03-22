package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Status;
import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Witch;
import com.worf.worf.service.exception.UnsupportedAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WitchProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(WitchProcessor.class);

    @Override
    public String process(Player source, Action action, Player target) {
        LOGGER.info("Witch's turn.");
        if (source.getRole() instanceof Witch) {
            if (source.getStatus() != Status.INACTIVE &&
                    (source.getRole().getAbilities().contains(Action.POISON)
                            || source.getRole().getAbilities().contains(Action.SAVE))) {
                switch (action) {
                    case POISON:
                        target.setStatus(Status.INACTIVATING);
                        return "Done";
                    case SAVE:
                        target.setStatus(Status.ACTIVE);
                        return "Done";
                    default:
                        throw new UnsupportedAction("Action is not supported", null);
                }
            } else {
                sleep();
            }
        }
        return null;

    }
}
