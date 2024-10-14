package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Permission implements GrantedAuthority {
    @Id
    private Long id;
    private String authority;

    public Permission(String authority) {
        this.authority = authority;
    }
}
