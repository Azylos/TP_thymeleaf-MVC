package com.dreams.azyl.tournois_esport.controller;

import org.springframework.ui.Model;
import com.dreams.azyl.tournois_esport.entity.TournamentStatus;
import com.dreams.azyl.tournois_esport.entity.Tournois;
import com.dreams.azyl.tournois_esport.service.TournoisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/")
public class AccueilController {

    private final TournoisService tournoisService;

    @Autowired
    public AccueilController(TournoisService tournoisService) {
        this.tournoisService = tournoisService;
    }

    @RequestMapping("/")
    public String accueil(Model model) {
//        List<Tournois> tournoisActifs = tournoisService.findByStatusIn(
//                List.of(TournamentStatus.OPEN, TournamentStatus.REGISTRATION)
//        );
        List<Tournois> tournoisActifs = tournoisService.findByStatus(TournamentStatus.OPEN);
        model.addAttribute("tournois", tournoisActifs);
        return "index";
    }
}
