package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.Entity;

@Entity
public class RoundRobinTournament extends Tournois {
    private Integer numberOfRounds;
    private Boolean homeAndAway;

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(Integer numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Boolean getHomeAndAway() {
        return homeAndAway;
    }

    public void setHomeAndAway(Boolean homeAndAway) {
        this.homeAndAway = homeAndAway;
    }
}

