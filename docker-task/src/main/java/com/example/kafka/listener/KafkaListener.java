package com.example.kafka.listener;

import com.example.model.dto.KafkaDto;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "customer", groupId = "notification-group")
    public void get(KafkaDto kafkaDto) {
        System.err.println("received data: " + kafkaDto.toString());
    }
    @org.springframework.kafka.annotation.KafkaListener(topics = "msg", groupId = "notification-group")
    public void getMsg(String msg) {
        System.err.println("received data: " + msg);
    }
}
