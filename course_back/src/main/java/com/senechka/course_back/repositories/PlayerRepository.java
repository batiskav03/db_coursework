package com.senechka.course_back.repositories;

import com.senechka.course_back.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
} 