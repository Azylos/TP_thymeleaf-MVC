package com.dreams.azyl.tournois_esport.controller;

import com.dreams.azyl.tournois_esport.entity.*;
import com.dreams.azyl.tournois_esport.form.TournoiForm;
import com.dreams.azyl.tournois_esport.service.JeuxService;
import com.dreams.azyl.tournois_esport.service.ModeJeuxService;
import com.dreams.azyl.tournois_esport.service.TournoisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tournois")
public class TournoisController {
    private final TournoisService tournoisService;
    private final JeuxService jeuxService;
    private final ModeJeuxService modeJeuxService;

    @Autowired
    public TournoisController(TournoisService tournoisService, JeuxService jeuxService, ModeJeuxService modeJeuxService) {
        this.tournoisService = tournoisService;
        this.jeuxService = jeuxService;
        this.modeJeuxService = modeJeuxService;
    }

    // Page intermédiaire
    @GetMapping("/choisir-format")
    public String choisirFormat() {
        return "tournois/choisir-format";
    }

    // Page de création après choix du format
    @GetMapping("/creation-tournois")
    public String creationTournois(@RequestParam(name = "format", required = false, defaultValue = "SINGLE_ELIMINATION") String format,
                                   Model model) {
        Tournois tournoi = tournoisService.createNewTournoi(format);
        model.addAttribute("tournoi", tournoi);
        model.addAttribute("format", format);
        model.addAttribute("jeux", jeuxService.findAll());
        model.addAttribute("modesJeux", modeJeuxService.findAll());
        model.addAttribute("format", format);
        model.addAttribute("form", new TournoiForm());

        return "tournois/creation-tournois";
    }

    @PostMapping("/create")
    public String enregistrerTournoi(@ModelAttribute TournoiForm form) {
        Tournois tournoi = tournoisService.createFromForm(form); // Nouvelle méthode à créer
        tournoisService.save(tournoi);
        return "redirect:/tournois";
    }

    @GetMapping
    public String listTournois(Model model) {
        model.addAttribute("tournois", tournoisService.findAll());
        return "tournois/list";
    }

    @GetMapping("/{id}")
    public String showTournoi(@PathVariable Long id, Model model) {
        return tournoisService.findById(id).map(tournoi -> {
            model.addAttribute("tournoi", tournoi);
            return "tournois/show";
        }).orElse("redirect:/tournois");
    }

    // Formulaire de modification
    @GetMapping("/{id}/edit")
    public String editJeuForm(@PathVariable Long id, Model model) {
        return tournoisService.findById(id).map(tournois -> {
            model.addAttribute("jeu", tournois);
            model.addAttribute("modes", tournoisService.findAll());
            return "tournois/edit";
        }).orElse("redirect:/tournois");
    }

    // Enregistrement modification
    @PostMapping("/{id}/edit")
    public String updateJeu(@PathVariable Long id, @ModelAttribute Tournois tournois) {
        tournoisService.update(id, tournois);
        return "redirect:/jeux";
    }

    @PostMapping("/{id}/delete")
    public String deleteTournoi(@PathVariable Long id) {
        tournoisService.deleteById(id);
        return "redirect:/tournois";
    }


}
