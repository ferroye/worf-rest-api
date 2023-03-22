package com.worf.worf.service.domain.role;


import com.worf.worf.service.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private int playerId;
    private Role role;
    private Status status = Status.ACTIVE;
}
