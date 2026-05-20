package com.sfg.biasca.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Allenamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Giorno giorno;

    private LocalTime oraInizio;
    private LocalTime oraFine;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;
}