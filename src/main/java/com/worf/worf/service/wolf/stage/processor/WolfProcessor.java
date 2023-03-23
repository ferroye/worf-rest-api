package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.ActionProcessorStatus;
import com.worf.worf.service.domain.ActionResponse;
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
    public ActionResponse process(Player source, Action action, Player target) {
//        this.getGame().
        if (source.getRole() instanceof Wolf) {
            if (!this.getGame().isDayTime()) {
                if (action == Action.KILL) {
                    target.setStatus(Status.INACTIVATING);
                    return new ActionResponse("Done", ActionProcessorStatus.DONE);
                } else {
                    throw new UnsupportedAction("Action is not supported", null);
                }
            } else {
                return null;// todo can add more logic here.
            }
        }
        return null;
    }
}
