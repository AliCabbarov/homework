package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.PostgreSQLDialect;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Where(clause = "status = true")
public class Cart implements Serializable {
    private static final Long serialVersionUID = 123158894L;
    @Id
    @GeneratedValue
    private Long id;
//    @ColumnTransformer(
//            read = "pgp_sym_decrypt(name::bytea, 'encryptionKey-test')",
//            write = "pgp_sym_encrypt(?, 'encryptionKey-test')"
//    )
    //CREATE EXTENSION IF NOT EXISTS pgcrypto;
    String name;
    @ManyToMany(fetch = FetchType.EAGER)
    Set<Product> products;
    @Builder.Default
    boolean status = true;

}
