package com.worf.worf.service.domain;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ActionResponse {
    private String message;
    private ActionProcessorStatus actionStatus;
}
