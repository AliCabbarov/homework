package com.company.classworkrelationhomework;

import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;
import java.util.function.Function;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
public class ClassworkRelationHomeworkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClassworkRelationHomeworkApplication.class, args);

    }

    @Override
    public void run(String... args) {
    }
}
