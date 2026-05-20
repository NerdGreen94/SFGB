package com.sfg.biasca.repository;

import com.sfg.biasca.Entity.Ruolo;
import com.sfg.biasca.Entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    // Per il login
    Optional<Utente> findByEmail(String email);

    // Tutti gli allenatori
    List<Utente> findByRuoliContaining(Ruolo ruolo);
}