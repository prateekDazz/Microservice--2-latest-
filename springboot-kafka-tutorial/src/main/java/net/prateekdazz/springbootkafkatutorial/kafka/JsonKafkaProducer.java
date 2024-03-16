package net.prateekdazz.springbootkafkatutorial.kafka;

import net.prateekdazz.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger logger  = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Value("${spring.kafka.json.topic}")
    private String kafkaJsonTopic;
    private KafkaTemplate<String, User>kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data)
    {
        logger.info("JsonKafkaProducer.java:: The  message to be sent by producer is "+ data.toString());
        Message<User>message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,kafkaJsonTopic).build();
        kafkaTemplate.send(message);
    }
}
