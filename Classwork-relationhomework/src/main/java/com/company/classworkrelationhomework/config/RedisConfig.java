package com.company.classworkrelationhomework.config;

import com.company.classworkrelationhomework.model.dto.response.CartResponseDto;
import com.company.classworkrelationhomework.model.entity.Cart;
import com.company.classworkrelationhomework.model.entity.Country;
import com.company.classworkrelationhomework.model.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.time.Duration;
import java.util.List;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Country> country() {
        RedisTemplate<String, Country> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer("UTF-8"));
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<String, List<Country>> countryList() {
        RedisTemplate<String, List<Country>> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer("UTF-8"));
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    LettuceConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<Long, CartResponseDto> productList() {
        RedisTemplate<Long, CartResponseDto> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer("UTF-8"));
        template.setKeySerializer(new GenericJackson2JsonRedisSerializer("UTF-8"));
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisTemplate<Long, Cart> cartRedisTemplate() {
        RedisTemplate<Long, Cart> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(RedisSerializer.java());
        template.setKeySerializer(RedisSerializer.java());
        template.afterPropertiesSet();
        return template;
    }

//    @Bean
//    public RedisTemplate<Long, Order> orderTemplate() {
//        RedisTemplate<Long, Order> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        template.setValueSerializer(RedisSerializer.java());
//        template.setKeySerializer(RedisSerializer.java());
//        template.afterPropertiesSet();
//        return template;
//    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues();

        RedisCacheConfiguration productCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues();


        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .withCacheConfiguration("product", productCacheConfig)
                .build();
    }

    @Bean
    public ConversionService conversionService() {
        GenericConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new OrderToStringConverter());
        return conversionService;
    }

    public static class OrderToStringConverter implements Converter<Order, String> {
        @Override
        public String convert(Order order) {
            return String.valueOf(order.getId());
        }
    }
}
