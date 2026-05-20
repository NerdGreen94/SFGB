package com.sfg.biasca.service;

import com.sfg.biasca.Entity.Ruolo;
import com.sfg.biasca.Entity.Utente;
import com.sfg.biasca.repository.UtenteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final PasswordEncoder passwordEncoder;

    public UtenteService(UtenteRepository utenteRepository, PasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public Utente findById(Long id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato con id: " + id));
    }

    public Utente findByEmail(String email) {
        return utenteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utente non trovato con email: " + email));
    }

    public List<Utente> findAllenatori() {
        return utenteRepository.findByRuoliContaining(Ruolo.ALLENATORE);
    }

    public List<Utente> findAtleti() {
        return utenteRepository.findByRuoliContaining(Ruolo.ATLETA);
    }

    public Utente save(Utente utente) {
        // Cripta la password prima di salvare
        if (utente.getPassword() != null && !utente.getPassword().isEmpty()) {
            utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        }
        return utenteRepository.save(utente);
    }

    public void deleteById(Long id) {
        utenteRepository.deleteById(id);
    }
}