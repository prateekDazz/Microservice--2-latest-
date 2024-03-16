package net.prateekdazz.springbootkafkatutorial.kafka;

import net.prateekdazz.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "${spring.kafka.json.topic}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumeJsonTopic(User user)
    {
        LOGGER.info("The  json message consumed by the consumer is >>"+user);
    }
}
