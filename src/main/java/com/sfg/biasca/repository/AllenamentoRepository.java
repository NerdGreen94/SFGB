package com.sfg.biasca.repository;

import com.sfg.biasca.Entity.Allenamento;
import com.sfg.biasca.Entity.Giorno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllenamentoRepository extends JpaRepository<Allenamento, Long> {

    // Tutti gli allenamenti di un corso
    List<Allenamento> findByCorsoId(Long corsoId);

    // Allenamenti per giorno (es. tutti i lunedì)
    List<Allenamento> findByGiorno(Giorno giorno);
}