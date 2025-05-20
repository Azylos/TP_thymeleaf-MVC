package com.dreams.azyl.tournois_esport.controller;

import com.dreams.azyl.tournois_esport.entity.ModeJeux;
import com.dreams.azyl.tournois_esport.service.ModeJeuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modes")
public class ModeJeuxController {
    private final ModeJeuxService modeJeuxService;

    @Autowired
    public ModeJeuxController(ModeJeuxService modeJeuxService) {
        this.modeJeuxService = modeJeuxService;
    }

    @GetMapping
    public String listModes(Model model) {
        model.addAttribute("modes", modeJeuxService.findAll());
        return "modes/list";
    }

    @GetMapping("/{id}")
    public String showMode(@PathVariable Long id, Model model) {
        return modeJeuxService.findById(id).map(mode -> {
            model.addAttribute("mode", mode);
            return "modes/show";
        }).orElse("redirect:/modes");
    }

    @GetMapping("/create")
    public String createModeForm(Model model) {
        model.addAttribute("mode", new ModeJeux());
        return "modes/create";
    }

    @PostMapping("/create")
    public String createMode(@ModelAttribute ModeJeux mode) {
        modeJeuxService.save(mode);
        return "redirect:/modes";
    }

    @GetMapping("/{id}/edit")
    public String editModeForm(@PathVariable Long id, Model model) {
        return modeJeuxService.findById(id).map(mode -> {
            model.addAttribute("mode", mode);
            return "modes/edit";
        }).orElse("redirect:/modes");
    }

    @PostMapping("/{id}/edit")
    public String updateMode(@PathVariable Long id, @ModelAttribute ModeJeux mode) {
        modeJeuxService.update(id, mode);
        return "redirect:/modes";
    }

    @PostMapping("/{id}/delete")
    public String deleteMode(@PathVariable Long id) {
        modeJeuxService.delete(id);
        return "redirect:/modes";
    }
}
