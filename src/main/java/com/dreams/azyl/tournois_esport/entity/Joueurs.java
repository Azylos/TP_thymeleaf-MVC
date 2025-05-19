package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Joueurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nickname;
    private Integer eloRating;

    @OneToOne
    private Utilisateurs user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyJoinColumn(name = "game_id")
    private Map<Jeux, StatistiqueJoueur> statistics;

    public Joueurs() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getEloRating() {
        return eloRating;
    }

    public void setEloRating(Integer eloRating) {
        this.eloRating = eloRating;
    }

    public Utilisateurs getUser() {
        return user;
    }

    public void setUser(Utilisateurs user) {
        this.user = user;
    }

    public Map<Jeux, StatistiqueJoueur> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<Jeux, StatistiqueJoueur> statistics) {
        this.statistics = statistics;
    }
}
