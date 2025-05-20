package com.dreams.azyl.tournois_esport.service;

import com.dreams.azyl.tournois_esport.entity.*;
import com.dreams.azyl.tournois_esport.form.TournoiForm;
import com.dreams.azyl.tournois_esport.repository.TournoisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TournoisService {

    private final TournoisRepository tournoisRepository;
    private final JeuxService jeuxService;
    private final ModeJeuxService modeJeuxService;

    @Autowired
    public TournoisService(TournoisRepository tournoisRepository, JeuxService jeuxService, ModeJeuxService modeJeuxService) {
        this.tournoisRepository = tournoisRepository;
        this.jeuxService = jeuxService;
        this.modeJeuxService = modeJeuxService;
    }

    /**
     * Récupère tous les tournois
     */
    public List<Tournois> findAll() {
        return tournoisRepository.findAll();
    }

    /**
     * Récupère un tournoi par son identifiant
     */
    public Optional<Tournois> findById(Long id) {
        return tournoisRepository.findById(id);
    }

    /**
     * Récupère les tournois ayant un statut spécifique
     */
    public List<Tournois> findByStatus(TournamentStatus status) {
        return tournoisRepository.findByStatus(status);
    }

    /**
     * Récupère les tournois ayant un statut parmi une liste de statuts
     */
    public List<Tournois> findByStatusIn(List<TournamentStatus> statuses) {
        return tournoisRepository.findByStatusIn(statuses);
    }

    /**
     * Récupère les tournois à venir (date de début supérieure à maintenant)
     */
    public List<Tournois> findUpcomingTournaments() {
        return tournoisRepository.findByStartDateAfter(LocalDateTime.now());
    }

    /**
     * Récupère les tournois à venir avec un statut particulier
     */
    public List<Tournois> findUpcomingTournamentsByStatus(TournamentStatus status) {
        return tournoisRepository.findByStartDateAfterAndStatus(LocalDateTime.now(), status);
    }

    /**
     * Enregistre un tournoi
     */
    public Tournois save(Tournois tournois) {
        return tournoisRepository.save(tournois);
    }

    /**
     * Supprime un tournoi par son identifiant
     */
    public void deleteById(Long id) {
        tournoisRepository.deleteById(id);
    }

    /**
     * création d'un tournois par type
     */
    public Tournois createNewTournoi(String format) {
        return switch (format.toUpperCase()) {
            case "SINGLE_ELIMINATION" -> new SingleEliminationTournament();
            case "DOUBLE_ELIMINATION" -> new DoubleEliminationTournament();
            case "ROUND_ROBIN" -> new RoundRobinTournament();
            default -> throw new IllegalArgumentException("Format inconnu : " + format);
        };
    }

    public Tournois createFromForm(TournoiForm form) {
        if (form.getTournamentFormat() == null) {
            throw new IllegalArgumentException("Le format du tournoi est obligatoire.");
        }

        Tournois tournoi = createNewTournoi(form.getTournamentFormat());

        tournoi.setName(form.getName());
        tournoi.setDescription(form.getDescription());
        tournoi.setStartDate(form.getStartDate());
        tournoi.setEndDate(form.getEndDate());
        tournoi.setMaxParticipants(form.getMaxParticipants());
        tournoi.setStatus(form.getStatus());
        Jeux jeu = jeuxService.findById(form.getGameId())
                .orElseThrow(() -> new IllegalArgumentException("Jeu non trouvé"));
        tournoi.setGame(jeu);

        ModeJeux mode = modeJeuxService.findById(form.getGameModeId())
                .orElseThrow(() -> new IllegalArgumentException("Mode de jeu non trouvé"));
        tournoi.setGameMode(mode);

        if (tournoi instanceof SingleEliminationTournament) {
            tournoi.setType(form.getTournamentFormat());
        } else if (tournoi instanceof DoubleEliminationTournament) {
            tournoi.setType(form.getTournamentFormat());
        } else if (tournoi instanceof RoundRobinTournament) {
            tournoi.setType(form.getTournamentFormat());
        }

        return tournoi;
    }

    public Optional<Tournois> update(Long id, Tournois form) {
        return tournoisRepository.findById(id).map(tournoi -> {
            tournoi.setName(form.getName());
            tournoi.setDescription(form.getDescription());
            tournoi.setStartDate(form.getStartDate());
            tournoi.setEndDate(form.getEndDate());
            tournoi.setMaxParticipants(form.getMaxParticipants());
            tournoi.setStatus(form.getStatus());
            return tournoisRepository.save(tournoi);
        });
    }

}
