package com.worf.worf.service.domain;

import com.worf.worf.service.domain.role.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Game {
    private UUID id;
    private List<Player> players;
    private WinCondition winCondition;
    private List<String> gameReplayLogs;
}
