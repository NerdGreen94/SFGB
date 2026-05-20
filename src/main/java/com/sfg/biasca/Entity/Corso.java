package com.sfg.biasca.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descrizione;

    private int etaMin;
    private int etaMax;

    private double prezzo;
    private int maxIscritti;

    @ManyToOne
    @JoinColumn(name = "settore_id")
    private Settore settore;

    @ManyToMany
    @JoinTable(
            name = "corso_allenatore",
            joinColumns = @JoinColumn(name = "corso_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id")
    )
    private List<Utente> allenatori;

    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Allenamento> allenamenti;

    // Utility — nome del settore usato come tag sulla card
    public String getTag() {
        return settore != null ? settore.getNome() : null;
    }
}