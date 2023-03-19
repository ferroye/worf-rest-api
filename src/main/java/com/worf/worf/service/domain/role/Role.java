package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Action;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Role{
    private String roleName;
    private List<Action> abilities;
}
