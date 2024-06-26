package com.example.kafka.producer;

import com.example.model.dto.KafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final String TOPIC = "customer";
    private static final String TOPIC_TO_MSG = "msg";

    @Autowired
    private KafkaTemplate<String, KafkaDto> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateToString;

    public void sendKafkaDto(KafkaDto kafkaDto) {
        kafkaTemplate.send(TOPIC, kafkaDto);
    }
    public void sendString(String message) {
        kafkaTemplateToString.send(TOPIC_TO_MSG, message);
    }

}
