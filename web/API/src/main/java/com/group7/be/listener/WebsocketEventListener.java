package com.group7.be.listener;

import com.group7.be.enumerate.MessageType;
import com.group7.be.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class WebsocketEventListener {
    @Autowired
    private SimpMessageSendingOperations messageTemplate;

    Logger logger = LoggerFactory.getLogger(WebsocketEventListener.class);

    @EventListener
    public void handleWebsocketConnection(SessionConnectedEvent event) {
        logger.info("connection socket");
    }

    @EventListener
    public void handleWebsocketDisconnection(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("user connection !");
            Message message = new Message();
//            message.setType(MessageType.LEAVE);
            message.setSender(username);

            messageTemplate.convertAndSend("/topic/public", message);
        }
    }
}
