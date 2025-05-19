package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime scheduledTime;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @ManyToMany
    private List<Joueurs> participants;

    @OneToOne(cascade = CascadeType.ALL)
    private Score score;

    @ManyToOne
    private Tournois tournament;

    @OneToOne
    private Match nextMatch;

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public List<Joueurs> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Joueurs> participants) {
        this.participants = participants;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Tournois getTournament() {
        return tournament;
    }

    public void setTournament(Tournois tournament) {
        this.tournament = tournament;
    }

    public Match getNextMatch() {
        return nextMatch;
    }

    public void setNextMatch(Match nextMatch) {
        this.nextMatch = nextMatch;
    }
}
