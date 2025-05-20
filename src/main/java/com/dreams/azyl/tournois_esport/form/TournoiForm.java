package com.dreams.azyl.tournois_esport.form;

import com.dreams.azyl.tournois_esport.entity.TournamentStatus;

import java.time.LocalDateTime;

public class TournoiForm {
    private String name;
    private String description;
    private Long gameId;
    private Long gameModeId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer maxParticipants;
    private String tournamentFormat; // SINGLE_ELIMINATION, etc.
    private String rulesDescription;
    private boolean hasPrizes;
    private String prizesDescription;
    private String firstPrize;
    private String secondPrize;
    private String thirdPrize;
    private TournamentStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameModeId() {
        return gameModeId;
    }

    public void setGameModeId(Long gameModeId) {
        this.gameModeId = gameModeId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getTournamentFormat() {
        return tournamentFormat;
    }

    public void setTournamentFormat(String tournamentFormat) {
        this.tournamentFormat = tournamentFormat;
    }

    public String getRulesDescription() {
        return rulesDescription;
    }

    public void setRulesDescription(String rulesDescription) {
        this.rulesDescription = rulesDescription;
    }

    public boolean isHasPrizes() {
        return hasPrizes;
    }

    public void setHasPrizes(boolean hasPrizes) {
        this.hasPrizes = hasPrizes;
    }

    public String getPrizesDescription() {
        return prizesDescription;
    }

    public void setPrizesDescription(String prizesDescription) {
        this.prizesDescription = prizesDescription;
    }

    public String getFirstPrize() {
        return firstPrize;
    }

    public void setFirstPrize(String firstPrize) {
        this.firstPrize = firstPrize;
    }

    public String getSecondPrize() {
        return secondPrize;
    }

    public void setSecondPrize(String secondPrize) {
        this.secondPrize = secondPrize;
    }

    public String getThirdPrize() {
        return thirdPrize;
    }

    public void setThirdPrize(String thirdPrize) {
        this.thirdPrize = thirdPrize;
    }

    public TournamentStatus getStatus() {
        return status;
    }

    public void setStatus(TournamentStatus status) {
        this.status = status;
    }

// Getters & setters
    // (Génère-les tous via ton IDE)
}

