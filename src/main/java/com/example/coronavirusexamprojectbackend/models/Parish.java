package com.example.coronavirusexamprojectbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    private int parishCode;
    private String parishName;
    private double infectionPercentage;
    private LocalDate quarantineDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "municipalityId")
    private Municipality municipality;

    public Parish(int parishCode, String parishName, double infectionPercentage, LocalDate quarantineDate, Municipality municipality) {
        this.parishCode = parishCode;
        this.parishName = parishName;
        this.infectionPercentage = infectionPercentage;
        this.quarantineDate = quarantineDate;
        this.municipality = municipality;
    }
}
