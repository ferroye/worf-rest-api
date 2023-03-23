package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.ActionResponse;
import com.worf.worf.service.domain.role.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ElectChiefProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(ElectChiefProcessor.class);
    @Override
    public ActionResponse process(Player source, Action action, Player target) {
        LOGGER.info("Chief 's turn TODO:");
        //todo : implement this
//        if (this.getGame().getNightNo()==0) {
//            switch (action) {
//                case :
//                    target.setStatus(act);
//                    return "Done";
//                default:
//                    throw new UnsupportedAction("Action is not supported", null);
//            }
//        }
        return null;
    }
}
