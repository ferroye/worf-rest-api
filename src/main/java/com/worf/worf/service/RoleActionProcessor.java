package com.worf.worf.service;

import com.worf.worf.service.domain.Action;
import com.worf.worf.service.domain.Game;
import com.worf.worf.service.domain.role.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class RoleActionProcessor {
    private Game game;

    public abstract String process(Player source, Action action, Player target);

    public void sleep() {
        Random random = new Random();
        int minSleepTime = 10000; //10 seconds
        int additionalSleepTime = random.nextInt(10000); // additional random sleep time in milliseconds
        try {
            Thread.sleep(minSleepTime + additionalSleepTime);
        } catch (InterruptedException e) {
            // handle the exception here
            e.printStackTrace();
        }
    }
}
