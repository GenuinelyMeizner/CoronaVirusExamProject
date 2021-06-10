package com.example.coronavirusexamprojectbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "municipalities")
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long municipalityId;
    private String municipalityName;
    private int municipalityCode;

    @OneToMany(mappedBy = "municipality")
    @JsonBackReference
    Set<Parish> parishes = new HashSet<>();

    public Municipality(String municipalityName, int municipalityCode) {
        this.municipalityName = municipalityName;
        this.municipalityCode = municipalityCode;
    }
}
