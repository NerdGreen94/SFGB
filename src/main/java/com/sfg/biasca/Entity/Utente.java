package com.sfg.biasca.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String foto;
    private String bio;

    // Credenziali login
    private String email;
    private String password;

    // Ruoli (ADMIN, ALLENATORE, ATLETA — combinabili)
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Ruolo> ruoli;

    // Corsi a cui è associato come allenatore
    @ManyToMany(mappedBy = "allenatori")
    private List<Corso> corsi;

    // Record personali (solo se ATLETA)
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecordPersonale> recordPersonali;

    // Calcolo età automatico
    public int getEta() {
        if (dataNascita == null) return 0;
        return Period.between(dataNascita, LocalDate.now()).getYears();
    }

    // Utility ruoli
    public boolean isAtleta() {
        return ruoli != null && ruoli.contains(Ruolo.ATLETA);
    }

    public boolean isAllenatore() {
        return ruoli != null && ruoli.contains(Ruolo.ALLENATORE);
    }

    public boolean isAdmin() {
        return ruoli != null && ruoli.contains(Ruolo.ADMIN);
    }
}