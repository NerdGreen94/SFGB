package com.sfg.biasca.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
public class Settore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String url;

   // @ManyToMany(mappedBy = "settori")
    //private List<Utente> utenti;
}