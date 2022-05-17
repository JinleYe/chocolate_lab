package com.bnta.chocolate.repositories;

import com.bnta.chocolate.models.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstateRepository extends JpaRepository<Estate, Long> {
    List<Estate> findAll();
    List<Estate> findEstatesByCountry(String country);
}
