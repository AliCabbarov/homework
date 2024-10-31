package com.company.classworkrelationhomework.kafka.listener;

import com.company.classworkrelationhomework.kafka.producer.OrderProducer;
import com.company.classworkrelationhomework.model.entity.Order;
import com.company.classworkrelationhomework.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderListener {
    private static final String TOPIC = "orders";

    @KafkaListener(topics = TOPIC, groupId = "orders_group")
    public Order consume(Order order) {
        log.info(String.format("#### -> Consumed message -> %s", order));
        return order;
    }
}
