package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.RoleActionProcessor;
import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.role.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SeerProcessor extends RoleActionProcessor {
    Logger LOGGER = LoggerFactory.getLogger(SeerProcessor.class);
    @Override
    public void process(Player source, Action action, Player target) {
        LOGGER.info("Seer's turn.");
    }
}
