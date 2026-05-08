package com.sfg.biasca.controller;

import com.sfg.biasca.Entity.Settore;
import com.sfg.biasca.repository.SettoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SettoreController {

    private final SettoreRepository settoreRepository;

    public SettoreController(SettoreRepository settoreRepository) {
        this.settoreRepository = settoreRepository;
    }

    @GetMapping("/form")
    public String showForm(Model model) {

        List<Settore> settori = settoreRepository.findAll();

        model.addAttribute("settori", settori);

        return "form";
    }
}