package com.company.classworkrelationhomework.kafka.producer;

import com.company.classworkrelationhomework.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private static final String TOPIC = "orders";

    public void send(Order order) {
        kafkaTemplate.send(TOPIC,"order", order);
    }
}
