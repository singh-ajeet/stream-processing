package org.ajeet.learnings.streaming.collection.rsvpcollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RsvpsKafkaProducer {
    private static final String TOPIC = "meetup-rsvp";
    private static final Logger LOG = LoggerFactory.getLogger(RsvpsKafkaProducer.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        //     LOG.info("message produced ->" + message);
        kafkaTemplate.send(TOPIC, message);
    }
}
