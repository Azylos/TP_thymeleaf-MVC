package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private Map<Joueurs, Integer> playerScores;

    @ManyToOne
    private Joueurs winner;

    private Boolean forfeit;

    public Score() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Joueurs, Integer> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(Map<Joueurs, Integer> playerScores) {
        this.playerScores = playerScores;
    }

    public Joueurs getWinner() {
        return winner;
    }

    public void setWinner(Joueurs winner) {
        this.winner = winner;
    }

    public Boolean getForfeit() {
        return forfeit;
    }

    public void setForfeit(Boolean forfeit) {
        this.forfeit = forfeit;
    }
}

