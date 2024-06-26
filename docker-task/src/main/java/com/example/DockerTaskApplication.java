package com.example;

import com.example.kafka.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DockerTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerTaskApplication.class, args);
    }
}
