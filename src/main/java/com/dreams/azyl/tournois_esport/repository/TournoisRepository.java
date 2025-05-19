package com.dreams.azyl.tournois_esport.repository;

import com.dreams.azyl.tournois_esport.entity.TournamentStatus;
import com.dreams.azyl.tournois_esport.entity.Tournois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TournoisRepository extends JpaRepository<Tournois, Long> {
    /**
     * Trouve tous les tournois avec un statut spécifique
     */
    List<Tournois> findByStatus(TournamentStatus status);

    /**
     * Trouve tous les tournois dont le statut est dans la liste fournie
     */
    List<Tournois> findByStatusIn(List<TournamentStatus> statuses);

    /**
     * Trouve tous les tournois qui commencent après la date fournie
     */
    List<Tournois> findByStartDateAfter(LocalDateTime date);

    /**
     * Trouve tous les tournois qui commencent après la date fournie et qui ont un statut spécifique
     */
    List<Tournois> findByStartDateAfterAndStatus(LocalDateTime date, TournamentStatus status);

    /**
     * Trouve tous les tournois associés à un jeu spécifique
     */
    List<Tournois> findByGameId(Long gameId);

    /**
     * Trouve tous les tournois associés à un mode de jeu spécifique
     */
    List<Tournois> findByGameModeId(Long gameModeId);
}
