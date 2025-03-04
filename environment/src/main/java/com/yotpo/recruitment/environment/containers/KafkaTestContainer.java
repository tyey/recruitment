package com.yotpo.recruitment.environment.containers;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.EmbeddedKafkaZKBroker;

@Configuration
@EnableKafka
public class KafkaTestContainer {

    @Bean
    public EmbeddedKafkaBroker embeddedKafkaBroker() {
        return new EmbeddedKafkaZKBroker(1)
            .kafkaPorts(9092) // Set a fixed port
            .brokerProperty("log.dir", "./kafka-logs");
    }

    @Bean
    public NewTopic customerEventsTopic() {
        return TopicBuilder.name("customer-events").partitions(3).replicas(1).build();
    }
}
