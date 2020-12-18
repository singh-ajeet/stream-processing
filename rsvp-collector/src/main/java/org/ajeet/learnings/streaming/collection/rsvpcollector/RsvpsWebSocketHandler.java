package org.ajeet.learnings.streaming.collection.rsvpcollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

@Component
public class RsvpsWebSocketHandler extends AbstractWebSocketHandler {
    private static final Logger LOG =LoggerFactory.getLogger(RsvpsWebSocketHandler.class);

    @Autowired
    RsvpsKafkaProducer meettupEventProducer;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //  LOG.info("Producing message ->" + message.getPayload());
        meettupEventProducer.sendMessage(message.getPayload());
    }
}
