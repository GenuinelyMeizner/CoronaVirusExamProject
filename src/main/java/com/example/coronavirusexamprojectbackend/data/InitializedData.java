package com.example.coronavirusexamprojectbackend.data;

import com.example.coronavirusexamprojectbackend.models.Municipality;
import com.example.coronavirusexamprojectbackend.models.Parish;
import com.example.coronavirusexamprojectbackend.repositories.ParishRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class InitializedData {

    private final ParishRepository parishRepository;

    @Bean
    public void insertDefaultData() {
        Municipality municipality1 = new Municipality("Vejle", 630);
        Parish parish1 = new Parish("Givskud", 7975, 1217, 1150.37, 14, 3.66, true, LocalDate.parse("2021-06-03"), municipality1);
        parishRepository.save(parish1);

        Municipality municipality2 = new Municipality("Aalborg", 851);
        Parish parish2 = new Parish("Budfolfi", 8364, 7216, 706.76, 51, 3.11, true, LocalDate.parse("2021-05-30"), municipality2);
        parishRepository.save(parish2);

        Municipality municipality3 = new Municipality("Aalborg", 851);
        Parish parish3 = new Parish("Vor Frelsers", 8366, 6522, 689.97, 45, 3.37, true, LocalDate.parse("2021-05-24"), municipality3);
        parishRepository.save(parish3);

        Municipality municipality4 = new Municipality("Aalborg", 851);
        Parish parish4 = new Parish("Vor Frue", 8368, 7180, 459.61, 33, 2.34, true, LocalDate.parse("2021-06-04"), municipality4);
        parishRepository.save(parish4);

        Municipality municipality5 = new Municipality("Vesthimmerlands", 820);
        Parish parish5 = new Parish("Fovlum", 8284, 392, 1530.61, 6, 12.24, false, null, municipality5);
        parishRepository.save(parish5);

        Municipality municipality6 = new Municipality("Ringkøbing-Skjern", 760);
        Parish parish6 = new Parish("Faster", 8778, 887, 1465.61, 13, 6.16, false, null, municipality6);
        parishRepository.save(parish6);
    }
}
