package com.company.classworkrelationhomework;

import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.Product;
import com.company.classworkrelationhomework.repository.CartRepository;
import com.company.classworkrelationhomework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class ClassworkRelationHomeworkApplication implements CommandLineRunner {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClassworkRelationHomeworkApplication.class, args);

    }

    @Override
    public void run(String... args) {
//        create();
        print();

    }

    private void create() {
        Product product =
                Product.builder().id(1L).name("product-1").build();

        productRepository.save(product);

        Cart cart = Cart.builder()
                .id(1L)
                .name("cart-1")
                .products(Set.of(product))
                .build();

        cartRepository.save(cart);
    }

    @Transactional
    public void print() {
//        log.error("cart ->    {}", cartRepository.findById(1L).get());
        log.error("product -> {}", productRepository.findById(1L).get());
    }
}
