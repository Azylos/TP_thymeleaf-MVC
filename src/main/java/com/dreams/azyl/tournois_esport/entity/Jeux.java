package com.dreams.azyl.tournois_esport.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jeux {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String format;
    private Integer averageMatchDuration;

    @ManyToMany
    private List<ModeJeux> availableModes;

    public Jeux() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getAverageMatchDuration() {
        return averageMatchDuration;
    }

    public void setAverageMatchDuration(Integer averageMatchDuration) {
        this.averageMatchDuration = averageMatchDuration;
    }

    public List<ModeJeux> getAvailableModes() {
        return availableModes;
    }

    public void setAvailableModes(List<ModeJeux> availableModes) {
        this.availableModes = availableModes;
    }
}
