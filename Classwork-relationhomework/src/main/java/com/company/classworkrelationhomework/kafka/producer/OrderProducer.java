package com.company.classworkrelationhomework.kafka.producer;

import com.company.classworkrelationhomework.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private static final String TOPIC = "orders";

    public void send(Order order) {
        CompletableFuture<SendResult<String, Order>> completableFuture = kafkaTemplate.send(TOPIC, "order", order);
        completableFuture.thenAccept(sendResult -> System.out.println("Order sent successfully: " + sendResult))
                .exceptionally(throwable -> {
                    System.out.println("Order sending failed: " + throwable);
                    return null;
                });
    }

    public void sendWithMessage(Order order) {
        Message<Order> message = MessageBuilder.withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();
        CompletableFuture<SendResult<String, Order>> completableFuture = kafkaTemplate.send(message);
        completableFuture.thenAccept(sendResult -> System.out.println("Order sent successfully: " + sendResult))
                .exceptionally(throwable -> {
                    System.out.println("Order sending failed: " + throwable);
                    return null;
                });
    }

    public void sendWithProducerRecord(Order order) {
        ProducerRecord<String, Order> producerRecord = new ProducerRecord<>(TOPIC, "order", order);
        CompletableFuture<SendResult<String, Order>> completableFuture = kafkaTemplate.send(producerRecord);
        completableFuture.thenAccept(sendResult -> System.out.println("Order sent successfully: " + sendResult))
                .exceptionally(throwable -> {
                    System.out.println("Order sending failed: " + throwable);
                    return null;
                });
    }

    public void sendWithProducerRecordAndCallback(Order order) {
        ProducerRecord<String, Order> producerRecord = new ProducerRecord<>(TOPIC, "order", order);
        kafkaTemplate.send(producerRecord);
    }
}
