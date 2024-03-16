package net.prateekdazz.springbootkafkatutorial.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    public  static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @Value("${spring.kafka.topic}")
    private String kafkaTopic;

    private KafkaTemplate<String,String>kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate)  {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message)
    {
        LOGGER.info("The message sent is "+ message);
        kafkaTemplate.send(kafkaTopic,message);
    }
}
