package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private Long population;
    private String nativeLang;
    private Integer plateCode;
}
