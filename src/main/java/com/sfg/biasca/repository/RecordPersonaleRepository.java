package com.sfg.biasca.repository;

import com.sfg.biasca.Entity.RecordPersonale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordPersonaleRepository extends JpaRepository<RecordPersonale, Long> {

    // Tutti i record di un atleta
    List<RecordPersonale> findByUtenteId(Long utenteId);

    // Record per disciplina
    List<RecordPersonale> findByDisciplina(String disciplina);
}