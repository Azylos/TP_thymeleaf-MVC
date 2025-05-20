package com.dreams.azyl.tournois_esport.service;

import com.dreams.azyl.tournois_esport.entity.ModeJeux;
import com.dreams.azyl.tournois_esport.repository.ModeJeuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeJeuxService {
    private final ModeJeuxRepository modeJeuxRepository;

    @Autowired
    public ModeJeuxService(ModeJeuxRepository modeJeuxRepository) {
        this.modeJeuxRepository = modeJeuxRepository;
    }

    public List<ModeJeux> findAll() {
        return modeJeuxRepository.findAll();
    }

    public Optional<ModeJeux> findById(Long id) {
        return modeJeuxRepository.findById(id);
    }

    public ModeJeux save(ModeJeux modeJeux) {
        return modeJeuxRepository.save(modeJeux);
    }

    public Optional<ModeJeux> update(Long id, ModeJeux updated) {
        return modeJeuxRepository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setMinPlayers(updated.getMinPlayers());
            existing.setMaxPlayers(updated.getMaxPlayers());
            existing.setScoreToWin(updated.getScoreToWin());
            return modeJeuxRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (modeJeuxRepository.existsById(id)) {
            modeJeuxRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
