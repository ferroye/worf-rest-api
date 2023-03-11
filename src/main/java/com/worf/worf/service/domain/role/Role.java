package com.worf.worf.service.domain.role;

import com.worf.worf.service.domain.Ability;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Role{
    private List<Ability> abilities;
}
