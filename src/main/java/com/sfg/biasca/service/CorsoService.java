package com.sfg.biasca.service;

import com.sfg.biasca.Entity.Corso;
import com.sfg.biasca.repository.CorsoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorsoService {

    private final CorsoRepository corsoRepository;

    public CorsoService(CorsoRepository corsoRepository) {
        this.corsoRepository = corsoRepository;
    }

    public List<Corso> findAll() {
        return corsoRepository.findAll();
    }

    public Corso findById(Long id) {
        return corsoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Corso non trovato con id: " + id));
    }

    public List<Corso> findBySettore(Long settoreId) {
        return corsoRepository.findBySettoreId(settoreId);
    }

    public List<Corso> findByEta(int eta) {
        return corsoRepository.findByEtaMinLessThanEqualAndEtaMaxGreaterThanEqual(eta, eta);
    }

    public Corso save(Corso corso) {
        return corsoRepository.save(corso);
    }

    public void deleteById(Long id) {
        corsoRepository.deleteById(id);
    }
}