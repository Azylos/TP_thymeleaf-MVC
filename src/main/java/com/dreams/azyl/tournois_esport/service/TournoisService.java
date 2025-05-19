package com.dreams.azyl.tournois_esport.service;

import com.dreams.azyl.tournois_esport.entity.TournamentStatus;
import com.dreams.azyl.tournois_esport.entity.Tournois;
import com.dreams.azyl.tournois_esport.repository.TournoisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TournoisService {

    private final TournoisRepository tournoisRepository;

    @Autowired
    public TournoisService(TournoisRepository tournoisRepository) {
        this.tournoisRepository = tournoisRepository;
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
}
