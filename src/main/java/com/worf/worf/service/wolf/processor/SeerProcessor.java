package com.worf.worf.service.wolf.processor;

import com.worf.worf.service.StageProcessor;
import com.worf.worf.service.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeerProcessor implements StageProcessor {
    Logger LOGGER = LoggerFactory.getLogger(SeerProcessor.class);
    @Override
    public void process(Game game) {
        LOGGER.info("Seer Holder");
    }
}
