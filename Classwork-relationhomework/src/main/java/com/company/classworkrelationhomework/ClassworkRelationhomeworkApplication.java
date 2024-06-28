package com.company.classworkrelationhomework;

import com.company.classworkrelationhomework.projection.OrderProjection;
import com.company.classworkrelationhomework.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ClassworkRelationhomeworkApplication implements CommandLineRunner {
    private  final OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClassworkRelationhomeworkApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
    }
}
