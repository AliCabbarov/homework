package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.Generator;

@Entity(name = "_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
public class User {
    @Id
    @GenericGenerator(name = "user_id_generator")
    @GeneratedValue(strategy = GenerationType.UUID,generator = "user_id_generator")
    private long id;
    private String name;
    private String surname;
    private String username;
    private String password;
}
