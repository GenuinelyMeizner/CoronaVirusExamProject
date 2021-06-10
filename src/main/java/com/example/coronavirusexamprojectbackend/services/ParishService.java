package com.example.coronavirusexamprojectbackend.services;

import com.example.coronavirusexamprojectbackend.models.Parish;
import com.example.coronavirusexamprojectbackend.repositories.ParishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParishService {

    private final ParishRepository parishRepository;

    public Parish insertUpdateParish(Parish parish) {
        return parishRepository.save(parish);
    }

    public void deleteParish(Long parishId) {
        parishRepository.deleteById(parishId);
    }

    public List<Parish> getAllParishes() {
        return parishRepository.findAll();
    }
}
