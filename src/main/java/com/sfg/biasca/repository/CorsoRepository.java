package com.sfg.biasca.repository;

import com.sfg.biasca.Entity.Corso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {

    // Tutti i corsi di un settore
    List<Corso> findBySettoreId(Long settoreId);

    // Corsi per fascia d'età
    List<Corso> findByEtaMinLessThanEqualAndEtaMaxGreaterThanEqual(int eta, int eta2);
}