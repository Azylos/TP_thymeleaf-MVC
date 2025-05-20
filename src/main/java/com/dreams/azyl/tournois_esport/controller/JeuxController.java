package com.dreams.azyl.tournois_esport.controller;

import com.dreams.azyl.tournois_esport.entity.Jeux;
import com.dreams.azyl.tournois_esport.service.JeuxService;
import com.dreams.azyl.tournois_esport.service.ModeJeuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jeux")
public class JeuxController {

    private final JeuxService jeuxService;
    private final ModeJeuxService modeJeuxService;

    @Autowired
    public JeuxController(JeuxService jeuxService, ModeJeuxService modeJeuxService) {
        this.jeuxService = jeuxService;
        this.modeJeuxService = modeJeuxService;
    }

    // Liste
    @GetMapping
    public String listJeux(Model model) {
        model.addAttribute("jeuxList", jeuxService.findAll());
        return "jeux/list";
    }

    // Détail
    @GetMapping("/{id}")
    public String showJeu(@PathVariable Long id, Model model) {
        return jeuxService.findById(id).map(jeu -> {
            model.addAttribute("jeu", jeu);
            return "jeux/show";
        }).orElse("redirect:/jeux");
    }

    // Formulaire de création
    @GetMapping("/create")
    public String createJeuForm(Model model) {
        model.addAttribute("jeu", new Jeux());
        model.addAttribute("modes", modeJeuxService.findAll());
        return "jeux/create";
    }

    // Enregistrement
    @PostMapping("/create")
    public String createJeu(@ModelAttribute Jeux jeu) {
        jeuxService.save(jeu);
        return "redirect:/jeux";
    }

    // Formulaire de modification
    @GetMapping("/{id}/edit")
    public String editJeuForm(@PathVariable Long id, Model model) {
        return jeuxService.findById(id).map(jeu -> {
            model.addAttribute("jeu", jeu);
            model.addAttribute("modes", modeJeuxService.findAll());
            return "jeux/edit";
        }).orElse("redirect:/jeux");
    }

    // Enregistrement modification
    @PostMapping("/{id}/edit")
    public String updateJeu(@PathVariable Long id, @ModelAttribute Jeux jeu) {
        jeuxService.update(id, jeu);
        return "redirect:/jeux";
    }

    // Suppression
    @PostMapping("/{id}/delete")
    public String deleteJeu(@PathVariable Long id) {
        jeuxService.delete(id);
        return "redirect:/jeux";
    }
}
