package com.worf.worf.game.room;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Getter @Setter
    private String from;
    @Getter @Setter
    private String to;
    @Getter @Setter
    private String content;
}