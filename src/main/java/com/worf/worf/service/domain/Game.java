package com.worf.worf.service.domain;

import com.worf.worf.service.domain.role.Player;
import com.worf.worf.service.domain.role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
@ToString
public class Game {
    private String id;
    private List<Player> players;
    private WinCondition winCondition;
    private List<String> gameActivities = new ArrayList<>();
    private boolean hasChief;
    private boolean dayTime;
    private int nightNo;
    private Role curRoleActionStage;
    private Queue<Role> stages = new LinkedList();
    private int totalStagesCount;
}
