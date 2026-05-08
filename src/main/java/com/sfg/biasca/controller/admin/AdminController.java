package com.sfg.biasca.controller.admin;

import com.sfg.biasca.Entity.Settore;
import com.sfg.biasca.repository.SettoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/settori")
public class AdminController {

    private final SettoreRepository repo;

    public AdminController(SettoreRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("settori", repo.findAll());
        model.addAttribute("settore", new Settore());
        return "admin/settori";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Settore settore) {
        System.out.println("NOME: " + settore.getNome());
        System.out.println("URL: " + settore.getUrl());
        repo.save(settore);
        return "redirect:/admin/settori";
    }
}