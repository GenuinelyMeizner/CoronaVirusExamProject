package com.example.coronavirusexamprojectbackend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name  = "parishes")
@Getter @Setter
@NoArgsConstructor
public class Parish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parish_id;
}
