package com.worf.worf.service.wolf.processor;

import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.wolf.GameManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitchProcessor implements StageProcessor {
    Logger LOGGER = LoggerFactory.getLogger(WitchProcessor.class);

    @Override
    public void process(Game game) {
        LOGGER.info("Witch's turn.");
    }
}
