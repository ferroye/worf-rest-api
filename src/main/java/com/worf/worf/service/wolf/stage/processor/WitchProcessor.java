package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.ActionProcessorStatus;
import com.worf.worf.service.domain.ActionResponse;
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
    public ActionResponse process(Player source, Action action, Player target) {
        LOGGER.info("Witch's turn.");
        if (source.getRole() instanceof Witch) {
            if (this.getGame().isDayTime()) {
                return null;
            }
            if (source.getStatus() != Status.INACTIVE &&
                    (source.getRole().getAbilities().contains(Action.POISON)
                            || source.getRole().getAbilities().contains(Action.SAVE))) {
                switch (action) {
                    case POISON:
                        if(!source.getRole().getAbilities().contains(Action.POISON))
                            return new ActionResponse("No more poison.", ActionProcessorStatus.CONTINUE);
                        target.setStatus(Status.INACTIVATING);
                        source.getRole().getAbilities().remove(Action.POISON);
                        return new ActionResponse("Done", ActionProcessorStatus.DONE);
                    case SAVE:
                        if(!source.getRole().getAbilities().contains(Action.SAVE))
                            return new ActionResponse("No more save.", ActionProcessorStatus.CONTINUE);
                        target.setStatus(Status.ACTIVE);
                        source.getRole().getAbilities().remove(Action.SAVE);
                        return new ActionResponse("Done", ActionProcessorStatus.DONE);
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
