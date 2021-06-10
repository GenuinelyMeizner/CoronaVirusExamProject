package com.example.coronavirusexamprojectbackend.repositories;

import com.example.coronavirusexamprojectbackend.models.Parish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParishRepository extends JpaRepository<Parish, Long> {
}
