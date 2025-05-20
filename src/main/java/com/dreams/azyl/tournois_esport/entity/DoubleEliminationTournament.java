package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DOUBLE")
public class DoubleEliminationTournament extends Tournois {
    private Boolean hasConsolationFinal;

    public Boolean getHasConsolationFinal() {
        return hasConsolationFinal;
    }

    public void setHasConsolationFinal(Boolean hasConsolationFinal) {
        this.hasConsolationFinal = hasConsolationFinal;
    }
}