package com.dreams.azyl.tournois_esport.service;

import com.dreams.azyl.tournois_esport.entity.Jeux;
import com.dreams.azyl.tournois_esport.repository.JeuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuxService {
    private final JeuxRepository jeuxRepository;

    @Autowired
    public JeuxService(JeuxRepository jeuxRepository) {
        this.jeuxRepository = jeuxRepository;
    }

    /**
     * Récupère tous les jeux
     */
    public List<Jeux> findAll() {
        return jeuxRepository.findAll();
    }

    /**
     * Récupère un jeu par son identifiant
     */
    public Optional<Jeux> findById(Long id) {
        return jeuxRepository.findById(id);
    }

    /**
     * Enregistre un jeu
     */
    public Jeux save(Jeux jeu) {
        return jeuxRepository.save(jeu);
    }

    /**
     * Supprime un jeu par son identifiant
     */
    public void deleteById(Long id) {
        jeuxRepository.deleteById(id);
    }

    public Optional<Jeux> update(Long id, Jeux newJeux) {
        return jeuxRepository.findById(id).map(existing -> {
            existing.setName(newJeux.getName());
            existing.setDescription(newJeux.getDescription());
            existing.setFormat(newJeux.getFormat());
            existing.setAverageMatchDuration(newJeux.getAverageMatchDuration());
            existing.setAvailableModes(newJeux.getAvailableModes());
            return jeuxRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (jeuxRepository.existsById(id)) {
            jeuxRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
