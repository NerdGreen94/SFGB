package com.sfg.biasca.service;

import com.sfg.biasca.Entity.RecordPersonale;
import com.sfg.biasca.repository.RecordPersonaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordPersonaleService {

    private final RecordPersonaleRepository recordPersonaleRepository;

    public RecordPersonaleService(RecordPersonaleRepository recordPersonaleRepository) {
        this.recordPersonaleRepository = recordPersonaleRepository;
    }

    public List<RecordPersonale> findByAtleta(Long utenteId) {
        return recordPersonaleRepository.findByUtenteId(utenteId);
    }

    public List<RecordPersonale> findByDisciplina(String disciplina) {
        return recordPersonaleRepository.findByDisciplina(disciplina);
    }

    public RecordPersonale save(RecordPersonale record) {
        return recordPersonaleRepository.save(record);
    }

    public void deleteById(Long id) {
        recordPersonaleRepository.deleteById(id);
    }
}