package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}