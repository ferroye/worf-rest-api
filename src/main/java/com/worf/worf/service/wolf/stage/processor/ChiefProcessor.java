package com.worf.worf.service.wolf.stage.processor;

import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChiefProcessor implements StageProcessor {
    Logger LOGGER = LoggerFactory.getLogger(ChiefProcessor.class);
    @Override
    public void process(Game game) {
        LOGGER.info("Chief 's turn");
    }
}
