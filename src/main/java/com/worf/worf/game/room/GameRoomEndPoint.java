package com.worf.worf.game.room;


import com.worf.worf.controller.GameController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value="/room/{roomName}")
public class GameRoomEndPoint {
    private static final Logger log = LoggerFactory.getLogger(GameRoomEndPoint.class);


    private Session session;
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(
            Session session,
            @PathParam("username") String username) throws IOException {

        this.session = session;
        users.put(session.getId(), username);
        Message message = new Message();
        session.getBasicRemote().sendText("");

        message.setFrom(username);
        message.setContent("Connected!");
    }

    @OnMessage
    public void onMessage(Session session, Message message)
            throws IOException {

        message.setFrom(users.get(session.getId()));
        sendMessage(session,message);
    }

    @OnClose
    public void onClose(Session session) throws IOException {

        Message message = new Message();
        session.getBasicRemote().sendText("Disconnected!");
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        sendMessage(session,message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.info(throwable.getMessage());
    }
    public void sendMessage(Session session,Message message) throws IOException {
        session.getBasicRemote().sendText("");
    }
}