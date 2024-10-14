package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Role;
import com.company.classworkrelationhomework.model.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(Roles role);
}