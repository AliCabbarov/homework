package com.company.classworkrelationhomework;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
@EnableFeignClients
public class ClassworkRelationHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClassworkRelationHomeworkApplication.class, args);

    }

    @Override
    public void run(String... args) {
    }
}
