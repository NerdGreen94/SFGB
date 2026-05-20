package com.sfg.biasca.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class RecordPersonale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disciplina;      // es. "100m", "Salto in lungo"
    private String risultato;       // es. "10.5s", "6.80m"
    private LocalDate dataRecord;
    private String luogoCompetizione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
}