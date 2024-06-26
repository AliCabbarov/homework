package com.example.controller;

import com.example.kafka.producer.KafkaProducer;
import com.example.model.dto.KafkaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class Controller {
    @Autowired
    private KafkaProducer kafkaProducer;
    @PostMapping()
    public String send(@RequestBody KafkaDto kafkaDto){
        kafkaProducer.sendKafkaDto(kafkaDto);
        return "OK";
    }

    @PostMapping("/msg")
    public String send(@RequestBody String msg){
        kafkaProducer.sendString(msg);
        return "OK";
    }
}
