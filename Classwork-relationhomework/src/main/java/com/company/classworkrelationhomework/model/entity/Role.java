package com.company.classworkrelationhomework.model.entity;

import com.company.classworkrelationhomework.model.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Role {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Roles role;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> permission;
}
