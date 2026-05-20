package com.sfg.biasca.service;

import com.sfg.biasca.Entity.Allenamento;
import com.sfg.biasca.Entity.Giorno;
import com.sfg.biasca.repository.AllenamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllenamentoService {

    private final AllenamentoRepository allenamentoRepository;

    public AllenamentoService(AllenamentoRepository allenamentoRepository) {
        this.allenamentoRepository = allenamentoRepository;
    }

    public List<Allenamento> findByCorso(Long corsoId) {
        return allenamentoRepository.findByCorsoId(corsoId);
    }

    public List<Allenamento> findByGiorno(Giorno giorno) {
        return allenamentoRepository.findByGiorno(giorno);
    }

    public Allenamento save(Allenamento allenamento) {
        return allenamentoRepository.save(allenamento);
    }

    public void deleteById(Long id) {
        allenamentoRepository.deleteById(id);
    }
}