package com.company.classworkrelationhomework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.Generator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
public class User implements UserDetails {
    @Id
    @GenericGenerator(name = "user_id_generator")
    @GeneratedValue(strategy = GenerationType.UUID, generator = "user_id_generator")
    private long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String username;
    private String password;
    private boolean enabled;
    @ManyToOne(fetch = FetchType.EAGER)
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String name = role.getRole().name();
//        List<Permission> permissions = role.getPermission();
//        List<Permission> nonReferenceList = new ArrayList<>(permissions);
//        nonReferenceList.add(new Permission(name));
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
