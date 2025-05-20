package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ELIMINATION")
public class SingleEliminationTournament extends Tournois {
    private Boolean hasThirdPlaceMatch;

//    public SingleEliminationTournament() {
//    }

    public Boolean getHasThirdPlaceMatch() {
        return hasThirdPlaceMatch;
    }

    public void setHasThirdPlaceMatch(Boolean hasThirdPlaceMatch) {
        this.hasThirdPlaceMatch = hasThirdPlaceMatch;
    }
}