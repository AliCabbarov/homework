package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface CountryRepository extends JpaRepository<Country, Long> {
    @Override
    @Query("delete from Country where id =:id")
    @Modifying
    @Transactional
    void deleteById(Long id);
}
