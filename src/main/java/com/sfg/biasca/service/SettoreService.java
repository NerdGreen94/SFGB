package com.sfg.biasca.service;

import com.sfg.biasca.Entity.Settore;
import com.sfg.biasca.repository.SettoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettoreService {

    private final SettoreRepository settoreRepository;

    public SettoreService(SettoreRepository settoreRepository) {
        this.settoreRepository = settoreRepository;
    }

    public List<Settore> findAll() {
        return settoreRepository.findAll();
    }

    public Settore findById(Long id) {
        return settoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Settore non trovato con id: " + id));
    }

    public Settore save(Settore settore) {
        return settoreRepository.save(settore);
    }

    public void deleteById(Long id) {
        settoreRepository.deleteById(id);
    }
}