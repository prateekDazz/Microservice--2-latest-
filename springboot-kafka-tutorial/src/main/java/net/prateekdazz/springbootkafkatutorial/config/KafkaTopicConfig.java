package net.prateekdazz.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
@Value("${spring.kafka.topic}")
    private String kafkaTopic;
@Value("${spring.kafka.json.topic}")
private String kafkaJsonTopic;


    @Bean
    public NewTopic javaGuideTopic()
    {
        return TopicBuilder.name(kafkaTopic).build();
    }

    @Bean
    public NewTopic javaGuidesJsonTopic()
    {
        return TopicBuilder.name(kafkaJsonTopic).build();
    }
}
