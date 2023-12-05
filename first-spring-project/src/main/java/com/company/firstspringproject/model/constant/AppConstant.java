package com.company.firstspringproject.model.constant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties("app.constant.company")
public class AppConstant {
    /**@Value("${app.constant.company.description}") @ConfigurationProperties yazmayaraq bu şəkildə də yazmaq mümkündür */
    String name;
    String description;
    String phoneNumber;
}