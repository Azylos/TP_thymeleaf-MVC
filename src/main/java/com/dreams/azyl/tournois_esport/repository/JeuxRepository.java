package com.dreams.azyl.tournois_esport.repository;

import com.dreams.azyl.tournois_esport.entity.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuxRepository extends JpaRepository<Jeux, Long> {
}