package com.example.coronavirusexamprojectbackend.repositories;

import com.example.coronavirusexamprojectbackend.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
}
