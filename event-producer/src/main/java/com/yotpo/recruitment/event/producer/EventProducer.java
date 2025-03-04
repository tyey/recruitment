package com.yotpo.recruitment.event.producer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yotpo.recruitment.event.producer.model.CustomerEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class EventProducer {

    private static final String TOPIC = "customer-events";

    private final KafkaTemplate<String, CustomerEvent> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath;

    public EventProducer(KafkaTemplate<String, CustomerEvent> kafkaTemplate, @Value("${file.path}") String filePath) {
        this.kafkaTemplate = kafkaTemplate;
        this.filePath = filePath;
        sendEventsFromFile();
    }

    public void sendEventsFromFile() {
        try {
            File file = new ClassPathResource(filePath).getFile();
            List<CustomerEvent> events = objectMapper.readValue(file, new TypeReference<List<CustomerEvent>>() {
            });

            for (CustomerEvent event : events) {
                kafkaTemplate.send(TOPIC, event);
                System.out.println("Sent event: " + event);
                Thread.sleep(500); // Simulate event streaming delay
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

