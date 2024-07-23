package com.company.classworkrelationhomework.repository;

import com.company.classworkrelationhomework.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CountryRepository extends JpaRepository<Country, Long> {
}
