package com.example.coronavirusexamprojectbackend.data;

import com.example.coronavirusexamprojectbackend.models.Municipality;
import com.example.coronavirusexamprojectbackend.models.Parish;
import com.example.coronavirusexamprojectbackend.repositories.MunicipalityRepository;
import com.example.coronavirusexamprojectbackend.repositories.ParishRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class InitializedData {
    private final ParishRepository parishRepository;
    private final MunicipalityRepository municipalityRepository;

    @Bean
    public void insertDefaultData() {
        Municipality municipality1 = new Municipality("Vejle", 630);
        Parish parish1 = new Parish(7975, "Givskud", 3.66, LocalDate.now(), municipality1);
        parishRepository.save(parish1);

        Municipality municipality2 = new Municipality("Aalborg", 851);
        Parish parish2 = new Parish(8364, "Budolfi", 3.11, LocalDate.now(), municipality2);
        parishRepository.save(parish2);

        Municipality municipality3 = new Municipality("Aalborg", 851);
        Parish parish3 = new Parish(8366, "Vor Frelsers", 3.37, LocalDate.now(), municipality3);
        parishRepository.save(parish3);

        Municipality municipality4 = new Municipality("Aalborg", 851);
        Parish parish4 = new Parish(8368, "Vor Frue", 2.34, LocalDate.now(), municipality4);
        parishRepository.save(parish4);
    }
}
