package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.User;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByEmailAndEnabled(String email, boolean enabled);

    @Transactional
//    @EntityGraph(attributePaths = {"User.role","Role.permissions"})
    @Query("select u from _user u join fetch u.role r left join fetch r.permission  where u.email =:email")
    Optional<User> findByEmail(String email);
}