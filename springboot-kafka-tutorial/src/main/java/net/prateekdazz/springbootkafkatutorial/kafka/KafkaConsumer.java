package net.prateekdazz.springbootkafkatutorial.kafka;

import net.prateekdazz.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER =LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "${spring.kafka.topic}",groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message)
    {
        LOGGER.info("The  message consumed by the consumer is >>"+message);
    }

}

