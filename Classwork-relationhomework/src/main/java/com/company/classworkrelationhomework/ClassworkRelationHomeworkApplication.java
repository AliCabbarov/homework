package com.company.classworkrelationhomework;

import com.company.classworkrelationhomework.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Function;

@SpringBootApplication
@RequiredArgsConstructor
public class ClassworkRelationHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClassworkRelationHomeworkApplication.class, args);

    }

    @Override
    public void run(String... args) {
    }
}
