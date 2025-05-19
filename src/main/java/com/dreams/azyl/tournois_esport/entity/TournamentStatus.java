package com.dreams.azyl.tournois_esport.entity;

public enum TournamentStatus {
    DRAFT,          // Brouillon, tournoi en cours de création
    REGISTRATION,   // Phase d'inscription
    OPEN,           // Tournoi ouvert et actif
    IN_PROGRESS,    // Tournoi en cours
    COMPLETED,      // Tournoi terminé
    CANCELLED       // Tournoi annulé
}