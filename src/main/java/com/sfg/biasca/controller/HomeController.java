package com.sfg.biasca.controller;

import com.sfg.biasca.repository.SettoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SettoreRepository repo;

    public HomeController(SettoreRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("settori", repo.findAll());

        return "index";
    }
}