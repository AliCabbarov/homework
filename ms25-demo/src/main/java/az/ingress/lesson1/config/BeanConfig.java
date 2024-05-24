package az.ingress.lesson1.config;

import az.ingress.lesson1.dto.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Configuration
public class BeanConfig {

    @Bean
    public Hello getHello() {
        return new Hello();
    }
}
