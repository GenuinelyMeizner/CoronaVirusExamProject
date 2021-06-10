package com.example.coronavirusexamprojectbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name  = "parishes")
@Getter @Setter
@NoArgsConstructor
public class Parish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parishId;
    private String parishName;
    private int parishCode;
    private int parishInhabitants;
    private double parishNumberOfIncidents;
    private int parishNumberOfNewInfected;
    private double parishPercentageOfInfected;
    private boolean parishUnderAutomaticLockdown;
    private LocalDate parishDateOfAutomaticLockdown;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "municipalityId")
    private Municipality municipality;

    public Parish(String parishName, int parishCode, int parishInhabitants, double parishNumberOfIncidents, int parishNumberOfNewInfected, double parishPercentageOfInfected, boolean parishUnderAutomaticLockdown, LocalDate parishDateOfAutomaticLockdown, Municipality municipality) {
        this.parishName = parishName;
        this.parishCode = parishCode;
        this.parishInhabitants = parishInhabitants;
        this.parishNumberOfIncidents = parishNumberOfIncidents;
        this.parishNumberOfNewInfected = parishNumberOfNewInfected;
        this.parishPercentageOfInfected = parishPercentageOfInfected;
        this.parishUnderAutomaticLockdown = parishUnderAutomaticLockdown;
        this.parishDateOfAutomaticLockdown = parishDateOfAutomaticLockdown;
        this.municipality = municipality;
    }
}
